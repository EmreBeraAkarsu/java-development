package com.pluralsight.NorthwindTradersSpringBoot4.dao.impl;

import com.pluralsight.NorthwindTradersSpringBoot4.dao.interfaces.IProductDao;
import com.pluralsight.NorthwindTradersSpringBoot4.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDAO implements IProductDao {


    private DataSource dataSource;

    @Autowired
    public JdbcProductDAO(DataSource dataSource) {
        this.dataSource = dataSource;
        initialize(); // Initialize database tables and data on startup.
    }

    private void initialize() {
        // This method sets up the database table and populates it with initial data if necessary.
        try (Connection connection = dataSource.getConnection()) {
            // SQL statement to create a transactions table if it does not exist.
            String createTableQuery = "CREATE TABLE IF NOT EXISTS transactions (" +
                    "transaction_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "amount DECIMAL(10, 2) NOT NULL," +
                    "vendor VARCHAR(255) NOT NULL" +
                    ")";
            try (PreparedStatement createTableStatement = connection.prepareStatement(createTableQuery)) {
                createTableStatement.execute(); // Execute the table creation query.
            }

            // Check if the table has any data already.
            String countQuery = "SELECT COUNT(*) AS rowCount FROM transactions";
            try (PreparedStatement countStatement = connection.prepareStatement(countQuery);
                 ResultSet resultSet = countStatement.executeQuery()) {
                if (resultSet.next() && resultSet.getInt("rowCount") == 0) {
                    // Insert initial data if the table is empty.
                    String insertDataQuery = "INSERT INTO transactions (amount, vendor) VALUES (?, ?)";
                    try (PreparedStatement insertDataStatement = connection.prepareStatement(insertDataQuery)) {
                        // Insert first transaction.
                        insertDataStatement.setDouble(1, 2000.00);
                        insertDataStatement.setString(2, "Raymond");
                        insertDataStatement.executeUpdate();

                        // Insert second transaction.
                        insertDataStatement.setDouble(1, 2500.00);
                        insertDataStatement.setString(2, "John");
                        insertDataStatement.executeUpdate();

                        // Insert third transaction.
                        insertDataStatement.setDouble(1, 4000.00);
                        insertDataStatement.setString(2, "Jane");
                        insertDataStatement.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }
    }

    @Override
    public Product insert(Product product) {
        // This method adds a new transaction to the database.
        String insertDataQuery = "INSERT INTO products (productname, categoryid, unitprice, ) VALUES (?,? ,?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement insertStatement = connection.prepareStatement(insertDataQuery, Statement.RETURN_GENERATED_KEYS)) {
            // Setting parameters for the insert query.

            insertStatement.setString(1, product.getProductName());
            insertStatement.setDouble(2, product.getCategoryId());
            insertStatement.setDouble(3, product.getUnitPrice());
            int affectedRows = insertStatement.executeUpdate(); // Execute the insert query.

            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }

            try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    product.setProductId(generatedId);
                } else {
                    throw new SQLException("Creating transaction failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }

        return product;
    }

    @Override
    public List<Product> getAll() {
        // This method retrieves all transactions from the database.
        List<Product> products = new ArrayList<>();
        String getAllQuery = "SELECT * FROM products";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(getAllQuery);
             ResultSet resultSet = selectStatement.executeQuery()) {
            while (resultSet.next()) {
                // Extract data from each row in the result set.
                double price = resultSet.getDouble("unitprice");
                String productName = resultSet.getString("productname");
                int categoryId = resultSet.getInt("categoryid");
                // Create a Transaction object and add it to the list.
                products.add(new Product(productName, categoryId, price));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }
        return products; // Return the list of transactions.
    }

    @Override
    public Product getById(int productId) {
        // This method retrieves a specific transaction by its ID.
        Product product = null;
        String getByIdQuery = "SELECT * FROM products WHERE productid = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(getByIdQuery)) {
            selectStatement.setInt(1, productId); // Set the ID parameter in the query.
            try (ResultSet resultSet = selectStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Extract data from the result set.
                    int productIdFromDb = resultSet.getInt("productid");
                    String  productName = resultSet.getString("productName");
                    int categoryId = resultSet.getInt("categoryID");
                    double amount = resultSet.getDouble("unitprice");

                    // Create a Transaction object.
                    product = new Product(productName, categoryId, amount);
                    product.setProductId(productIdFromDb);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }
        return product; // Return the found transaction or null.
    }

    @Override
    public void update(int productId, Product product) {
        // This method updates an existing product in the database.
        String updateDataQuery = "UPDATE products SET productname = ?, categoryid = ?, unitprice = ? WHERE productId = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement updateStatement = connection.prepareStatement(updateDataQuery)) {
            // Setting parameters for the update query.
            updateStatement.setString(1, product.getProductName());
            updateStatement.setInt(2, product.getCategoryId());
            updateStatement.setDouble(3, product.getUnitPrice());
            updateStatement.setInt(4, product.getProductId());
            updateStatement.executeUpdate(); // Execute the update query.

        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }
    }

    @Override
    public void delete(int productId) {
        // This method deletes a transaction from the database.
        String deleteDataQuery = "DELETE FROM products WHERE productId = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement deleteStatement = connection.prepareStatement(deleteDataQuery)) {
            deleteStatement.setInt(1, productId); // Set the ID parameter in the delete query.
            deleteStatement.executeUpdate(); // Execute the delete query.
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }
    }
}
