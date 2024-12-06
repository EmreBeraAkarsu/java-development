package com.pluralsight;

import com.pluralsight.db.DataManager;
import com.pluralsight.models.CustomerOrderHistory;
import com.pluralsight.models.SalesByYear;
import com.pluralsight.models.SearchByCategory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DataManager dataManager = new DataManager("jdbc:mysql://localhost:3306/northwind", "root", "P@ssw0rd");


        while (true) {
            System.out.println("Select one of the following:");
            System.out.println("1. Search Customer Order History");
            System.out.println("2. Search for sales by year");
            System.out.println("3. Search for sales by category");
            System.out.println("4. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    System.out.println("Enter a customer ID: ");
                    String customerID = scanner.nextLine();

                    List<CustomerOrderHistory> orderHistoryList = dataManager.searchCustomerOrderHistory(customerID);

                    System.out.println("Customer Order History:");
                    for (CustomerOrderHistory orderHistory : orderHistoryList) {
                        System.out.println("Product Name: " + orderHistory.getProductName()
                                + ", Total Quantity: " + orderHistory.getTotalQuantity());
                    }
                    break;

                case 2:
                    System.out.println("Enter a beginning date: ");
                    LocalDateTime beginDate = LocalDateTime.parse(scanner.nextLine());

                    System.out.println("Enter an end date: ");
                    LocalDateTime endDate = LocalDateTime.parse(scanner.nextLine());

                    List<SalesByYear> orderByYearList = dataManager.searchOrderByYear(beginDate, endDate);

                    System.out.println("Orders By Year:");

                    for (SalesByYear salesByYear : orderByYearList) {
                        System.out.println("ShippedDate: " + salesByYear.getShippedDate());
                        System.out.println("Id: " + salesByYear.getOrderId());
                        System.out.println("Subtotal: " + salesByYear.getSubtotal());
                        System.out.println("Year: " + salesByYear.getYear());
                    }
                    break;

                case 3:
                    System.out.println("Enter the category: ");
                    String category = scanner.nextLine();

                    System.out.println("Enter a year: ");
                    String year = scanner.nextLine();

                    List<SearchByCategory> searchByCategoryList = dataManager.searchByCategory(category, year);

                    System.out.println("Orders By Category:");

                    for (SearchByCategory searchByCategory : searchByCategoryList) {

                        System.out.println("Order total by category: " + searchByCategory.getTotalPrice());
                    }
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}