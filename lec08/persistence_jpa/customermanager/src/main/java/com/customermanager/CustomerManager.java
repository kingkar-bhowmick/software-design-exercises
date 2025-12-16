package com.customermanager;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerManager implements CommandLineRunner {

    @Autowired
    private CustomerRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(CustomerManager.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<CustomerTO> customers = new ArrayList<>(List.of(
                new CustomerTO(1001, "Alice", "Miller"),
                new CustomerTO(1002, "Bob", "Smith"),
                new CustomerTO(1003, "Carol", "Johnson"),
                new CustomerTO(1004, "David", "Williams"),
                new CustomerTO(1005, "Eve", "Brown")));

        // Insert customers
        repo.saveAll(customers);
        System.out.println("Inserted customers.");
        printCustomerList();
        waitForKey();

        // Read example customer
        CustomerTO c = null;
        try {
            c = repo.findById(1002).get();
            System.out.println("Loaded customer: " + c);
        } catch (NoSuchElementException e) {
            System.out.println("Customer not found");
        }
        printCustomerList();
        waitForKey();

        // Update and Delete example customer
        if (c != null) {
            // Update example customer
            c.setLastName("Anderson");
            repo.save(c);
            System.out.println("Updated customer: " + c);
            printCustomerList();
            waitForKey();

            // Delete example customer
            Integer customerId = c.getCustomerId();
            if (customerId != null) {
                repo.deleteById(customerId);
                System.out.println("Deleted customer with ID: " + customerId);
            }
            printCustomerList();
            waitForKey();
        }

        // Clear all customers
        repo.deleteAll();
        System.out.println("Cleared all customers.");
    }

    private void waitForKey() {
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

    private void printCustomerList() {
        System.out.println();
        System.out.println("Customer List:");
        List<CustomerTO> customers = repo.findAll();
        for (CustomerTO c : customers) {
            System.out.println(c);
        }
        System.out.println();
    }

}
