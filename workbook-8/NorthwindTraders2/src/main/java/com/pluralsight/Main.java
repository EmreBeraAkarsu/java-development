package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {

            if (args.length != 2){
                System.out.println("App needs 2 args to run!");
                System.exit(1);
            }

            String userName = args[0];
            String password = args[1];

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection;
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind",
                    userName,
                    password);


            Statement statement = connection.createStatement();


            String query = """
                    Select ProductName, ProductID, UnitPrice, UnitsInStock
                    from products;
                    """;

            //PreparedStatement preparedStatement = connection.prepareStatement(query);


            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Id       Name         Price         Stock\n" +
                    "---- -------------- ------- ------");


            while (resultSet.next()){

                String productID = resultSet.getString("ProductID");
                String productName = resultSet.getString("ProductName");
                String unitPrice = resultSet.getString("UnitPrice");
                String unitsInStock = resultSet.getString("UnitsInStock");

                System.out.println(productID + "        " + productName + "        " + unitPrice + "          " + unitsInStock);
            }

            resultSet.close();
            connection.close();
            statement.close();





        } catch (Exception e) {
            System.err.println("An error occured!");
            e.printStackTrace();
        }


    }
}
