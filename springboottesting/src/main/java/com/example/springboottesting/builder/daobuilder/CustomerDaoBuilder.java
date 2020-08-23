package com.example.springboottesting.builder.daobuilder;

import com.example.springboottesting.dao.bean.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.UUID;

@Component
public class CustomerDaoBuilder {

    public Customer buildDaoCustomer(com.example.springboottesting.model.Customer customer) {
        return new Customer(
                customer.getId() == null ? UUID.randomUUID() : customer.getId(),
                LocalDateTime.now(ZoneOffset.UTC),
                customer.getfName(),
                customer.getlName()
        );
    }

}
