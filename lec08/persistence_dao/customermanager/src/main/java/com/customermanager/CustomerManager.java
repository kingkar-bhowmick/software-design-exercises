package com.customermanager;

import java.io.Console;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {

    private static CustomerDAO customerDAO;

    public static void main(String[] args) {
        customerDAO = new SQLiteCustomerDAO();

        List<CustomerTO> customers = new ArrayList<>(List.of(
                new CustomerTO(1001, "Alice", "Miller"),
                new CustomerTO(1002, "Bob", "Smith"),
                new CustomerTO(1003, "Carol", "Johnson"),
                new CustomerTO(1004, "David", "Williams"),
                new CustomerTO(1005, "Eve", "Brown")));

        // Insert customers
        for (CustomerTO c : customers) {
            try {
                customerDAO.addCustomer(c);
                System.out.println("Added customer: " + c);
            } catch (SQLException e) {
                System.err.println("Error while saving " + c + ": " + e.getMessage());
            }
        }
        waitForKey();

        // Read example customer
        CustomerTO c = null;
        try {
            c = customerDAO.getCustomer(1002);
            System.out.println("Loaded customer: " + c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        printCustomerList();
        waitForKey();

        // Update and Delete example customer
        if (c != null) {
            // Update example customer
            c.setLastName("Anderson");
            try {
                customerDAO.updateCustomer(c);
                System.out.println("Updated customer: " + c);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            printCustomerList();
            waitForKey();

            // Delete example customer
            try {
                customerDAO.deleteCustomer(c.getCustomerId());
                System.out.println("Deleted customer with ID: " + c.getCustomerId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            printCustomerList();
            waitForKey();
        }

        // Clear all customers
        try {
            customerDAO.clear();
            System.out.println("Cleared all customers.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void waitForKey() {
        System.out.println("Press return to continue...");
        Console console = System.console();
        if (console != null) {
            console.readLine();
        } else {
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void printCustomerList() {
        System.out.println();
        System.out.println("Customer List:");
        try {
            List<CustomerTO> customers = customerDAO.getAllCustomers();
            for (CustomerTO c : customers) {
                System.out.println(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

}
