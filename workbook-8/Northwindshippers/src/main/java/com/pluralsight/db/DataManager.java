package com.pluralsight.db;

import com.pluralsight.models.Shipper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private DataSource dataSource;

    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertIntoDirect(String companyName, String phone) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "insert into shippers (CompanyName, Phone) values (?, ?)")) {
            preparedStatement.setString(1, companyName);
            preparedStatement.setString(2, phone);

            int rows = preparedStatement.executeUpdate();

            System.out.println("Rows Inserted: " + rows);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void insertIntoWithGeneratedKeys(String companyName, String phone ) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "insert into shippers (CompanyName, Phone) values (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, companyName);
            preparedStatement.setString(2, phone);

            int rows = preparedStatement.executeUpdate();

            System.out.println("Rows Inserted: " + rows);

            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                while (keys.next()) {
                    System.out.println("A new key was added: " + keys.getInt(1));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateRecord(int shipperId, String phone) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE shippers SET phone = ? WHERE shipperId = ?")) {
            preparedStatement.setString(1, phone);
            preparedStatement.setInt(2, shipperId);

            int rows = preparedStatement.executeUpdate();

            System.out.println("Rows Updated: " + rows);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public List<Shipper> getAllShippers() {
        List<Shipper> shippers = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM shippers")) {

            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    int shipperId = results.getInt("shipperId");
                    String companyName = results.getString("companyName");
                    String phone = results.getString("phone");

                    Shipper shipper = new Shipper(shipperId, companyName, phone);
                    shippers.add(shipper);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shippers;
    }

    public void deleteRecord(int shipperId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM shippers WHERE shipperId = ?")) {
            preparedStatement.setInt(1, shipperId);

            int rows = preparedStatement.executeUpdate();
            System.out.println("Rows Deleted: " + rows);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
