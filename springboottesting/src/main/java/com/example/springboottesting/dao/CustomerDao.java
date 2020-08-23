package com.example.springboottesting.dao;

import com.example.springboottesting.dao.bean.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerDao {

    List<Customer> findAllCustomers();

    Customer findCustomerById(UUID customerId);

    Customer insertCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(UUID customerId);

}
