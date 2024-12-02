package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        while (true) {
            String option = displayMenu(scanner);

            String query = setQuery(option);

            getResults(query, args, option);
        }

    }

    public static String displayMenu(Scanner scanner) {
        System.out.println("What do you want to do?\n" +
                "1) Display all products\n" +
                "2) Display all customers\n" +
                "0) Exit\n" +
                "Select an option:");
        return scanner.nextLine();

    }

    public static String setQuery(String option) {
        switch (option) {
            case "1":
                return "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";


            case "2":
                return "Select ContactName, CompanyName, City, Country, Phone  From customers Order By Country";


            case "0":
                System.exit(0);
                break;

            default:
                System.err.println("Invalid Option!");
                break;
        }
        return null;
    }

    public static void getResults(String query, String[] args, String option) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;


        try {
            if (args.length != 2) {
                System.out.println(
                        "Application needs two arguments to run: " + "java com.hca.jdbc.UsingDriverManager <username> " +
                                "<password>");
                System.exit(1);
            }

            // get the user name and password from the command line args
            String username = args[0];
            String password = args[1];

            // load the MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 1. open a connection to the database
            // use the database URL to point to the correct database
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind",
                    username,
                    password);

            // 2. Create a PreparedStatement
            statement = connection.prepareStatement(query);

            // 3. Execute the PreparedStatement and obtain the ResultSet
            results = statement.executeQuery();

            displayResults(option, results);

        } catch (Exception ex) {
            System.out.println("An error has occurred!");
            ex.printStackTrace();

        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void displayResults(String option, ResultSet results) {

        try {
            if (option.equalsIgnoreCase("1")) {
                while (results.next()) {
                    int productId = results.getInt("ProductID");
                    String productName = results.getString("ProductName");
                    double unitPrice = results.getDouble("UnitPrice");
                    int unitsInStock = results.getInt("UnitsInStock");

                    System.out.println("Product ID: " + productId);
                    System.out.println("Product Name: " + productName);
                    System.out.println("Unit Price: " + unitPrice);
                    System.out.println("Units In Stock: " + unitsInStock);
                    System.out.println("-----------------------------------------");
                }
            }

            if (option.equalsIgnoreCase("2")) {
                while (results.next()) {
                    String contactName = results.getString("ContactName");
                    String companyName = results.getString("CompanyName");
                    String city = results.getString("City");
                    String country = results.getString("Country");
                    String phone = results.getString("Phone");


                    System.out.println("ContactName: " + contactName);
                    System.out.println("CompanyName: " + companyName);
                    System.out.println("City: " + city);
                    System.out.println("Country: " + country);
                    System.out.println("Phone: " + phone);
                    System.out.println("-----------------------------------------");
                }

            }
        } catch (Exception ex) {
            System.out.println("An error has occurred!");
            ex.printStackTrace();
        } finally {
            if (results != null) {
                try {
                    results.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}