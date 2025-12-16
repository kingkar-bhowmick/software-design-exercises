package com.customermanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLiteCustomerDAO implements CustomerDAO {

    private static final String DB_URL = "jdbc:sqlite:customer_management.db";

    public SQLiteCustomerDAO() {
        String sql = """
                CREATE TABLE IF NOT EXISTS customers (
                    customer_id INTEGER NOT NULL PRIMARY KEY,
                    first_name  TEXT NOT NULL,
                    last_name   TEXT NOT NULL
                )
                """;

        try (Connection connection = DriverManager.getConnection(DB_URL);
                Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Error while initializing database", e);
        }
    }

    @Override
    public CustomerTO getCustomer(Integer customerId) throws SQLException {
        String sql = "SELECT * FROM customers WHERE customer_id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL);
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, customerId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRowToCustomer(rs);
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public void addCustomer(CustomerTO customer) throws SQLException {
        String sql = "INSERT INTO customers (customer_id, first_name, last_name) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL);
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, customer.getCustomerId());
            ps.setString(2, customer.getFirstName());
            ps.setString(3, customer.getLastName());
            ps.executeUpdate();
        }
    }

    @Override
    public void updateCustomer(CustomerTO customer) throws SQLException {
        String sql = "UPDATE customers SET first_name = ?, last_name = ? WHERE customer_id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL);
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setInt(3, customer.getCustomerId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteCustomer(Integer customerId) throws SQLException {
        String sql = "DELETE FROM customers WHERE customer_id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL);
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, customerId);
            ps.executeUpdate();
        }
    }

    @Override
    public List<CustomerTO> getAllCustomers() throws SQLException {
        String sql = "SELECT * FROM customers";
        List<CustomerTO> customers = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL);
                PreparedStatement ps = connection.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    customers.add(mapRowToCustomer(rs));
                }
            }
        }

        return customers;
    }

    @Override
    public void clear() throws SQLException {
        String sql = "DELETE FROM customers";
        try (Connection connection = DriverManager.getConnection(DB_URL);
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.executeUpdate();
        }
    }

    private CustomerTO mapRowToCustomer(ResultSet rs) throws SQLException {
        int id = rs.getInt("customer_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        return new CustomerTO(id, firstName, lastName);
    }
}
