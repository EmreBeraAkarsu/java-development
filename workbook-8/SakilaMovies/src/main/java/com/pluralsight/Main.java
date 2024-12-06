package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Check for command line arguments for username and password
        if (args.length != 2) {
            System.out.println("Application needs two arguments to run: " +
                    "java com.pluralsight.Main <username> <password>");
            System.exit(1);
        }

        String username = args[0];
        String password = args[1];

        Scanner scanner = new Scanner(System.in);

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        System.out.println("Enter a Last Name of an actor to search: ");
        String lastName = scanner.nextLine();

        searchByLastName(dataSource, lastName);

    }




    private static void searchByLastName(DataSource dataSource, String lastNameToSearch) {
        try {

            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(
                         """
                                 SELECT first_Name, last_Name
                                 FROM actor
                                 Where last_name = ?
                                 ORDER BY first_Name;
                                 """);



                 ResultSet resultSet = statement.executeQuery()) {


                statement.setString(1, lastNameToSearch);


                System.out.println("Actor found:");
                while (resultSet.next()) {
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    System.out.println(firstName + " " + lastName);
                }


                searchMoviesByActor(connection, lastNameToSearch);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void searchMoviesByActor(Connection connection, String lastNameToSearch) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first name");
        String firstName = scanner.nextLine();

        String query = """
                        SELECT title
                        FROM film f
                        join film_actor fa on f.film_id = fa.film_id
                        join actor a on fa.actor_id = a.actor_id
                        WHERE a.last_name like "?" and a.first_name like "?";
                        
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, lastNameToSearch);
            preparedStatement.setString(2, firstName);
            try (ResultSet productResultSet = preparedStatement.executeQuery()) {
                System.out.println("\nMovies for the selected actor: ");
                while (productResultSet.next()) {

                    String title = productResultSet.getString("Title");


                    System.out.println(title);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}