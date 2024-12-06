package com.pluralsight.db;

import com.pluralsight.models.CustomerOrderHistory;
import com.pluralsight.models.SalesByYear;
import com.pluralsight.models.SearchByCategory;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataManager {

    private BasicDataSource dataSource;

    public DataManager(String url, String username, String password) {
        this.dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }

    public List<CustomerOrderHistory> searchCustomerOrderHistory(String customerId) {
        List<CustomerOrderHistory> orderHistoryList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             CallableStatement statement = connection.prepareCall("{CALL CustOrderHist(?)}")) {
            statement.setString(1, customerId);

            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    String productName = results.getString("ProductName");
                    int totalQuantity = results.getInt("Total");

                    CustomerOrderHistory orderHistory = new CustomerOrderHistory(productName, totalQuantity);
                    orderHistoryList.add(orderHistory);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return orderHistoryList;
    }


    public List<SalesByYear> searchOrderByYear(LocalDateTime beginDate, LocalDateTime endDate) {
        List<SalesByYear> salesByYearList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             CallableStatement statement = connection.prepareCall("{CALL `Sales By Year`(?, ?)}")) {
            statement.setString(1, String.valueOf(beginDate));
            statement.setString(2, String.valueOf(endDate));

            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    LocalDateTime shippedDate = LocalDateTime.parse(results.getString("ShippedDate"));
                    int orderId = results.getInt("OrderID");
                    double subtotal = results.getFloat("Subtotal");
                    LocalDate year = LocalDate.parse(results.getString("Year"));

                    SalesByYear salesByYear = new SalesByYear(shippedDate, orderId, subtotal, year);
                    salesByYearList.add(salesByYear);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return salesByYearList;
    }


    public List<SearchByCategory> searchByCategory(String category, String year) {
        List<SearchByCategory> searchByCategoryList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             CallableStatement statement = connection.prepareCall("{CALL SalesByCategory(?, ?)}")) {
            statement.setString(1, category);
            statement.setString(2, year);

            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {

                    double total = results.getFloat("Total Purchase");

                    SearchByCategory searchByCategory = new SearchByCategory(total);
                    searchByCategoryList.add(searchByCategory);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return searchByCategoryList;
    }
}