package com.example.springboottesting.builder.modelbuilder;

import com.example.springboottesting.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerModelBuilder {

    public List<Customer> buildModelCustomers(List<com.example.springboottesting.dao.bean.Customer> customers) {
        List<Customer> customerList = new ArrayList<>();

        if (CollectionUtils.isEmpty(customers)) {
            return customerList;
        }

        return customers
                .stream()
                .map(customer -> buildModelCustomer(customer))
                .collect(Collectors.toList());

    }

    public Customer buildModelCustomer(com.example.springboottesting.dao.bean.Customer customer) {

        return new Customer(
                customer.getId(),
                customer.getfName(),
                customer.getlName(),
                customer.getfName() + " " + customer.getlName()
        );

    }
}
