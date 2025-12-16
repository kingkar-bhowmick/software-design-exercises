package com.customermanager;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {

    CustomerTO getCustomer(Integer customerId) throws SQLException;

    void addCustomer(CustomerTO customer) throws SQLException;

    void updateCustomer(CustomerTO customer) throws SQLException;

    void deleteCustomer(Integer customerId) throws SQLException;

    List<CustomerTO> getAllCustomers() throws SQLException;

    void clear() throws SQLException;
}
