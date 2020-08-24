package com.example.springboottesting.helper;

import com.example.springboottesting.builder.daobuilder.CustomerDaoBuilder;
import com.example.springboottesting.dao.CustomerDao;
import com.example.springboottesting.exception.ServiceException;
import com.example.springboottesting.model.Customer;
import com.example.springboottesting.builder.modelbuilder.CustomerModelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerHelper.class);

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerModelBuilder customerModelBuilder;

    @Autowired
    private CustomerDaoBuilder customerDaoBuilder;

    public ResponseEntity findAllCustomers() {
        String strMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        ResponseEntity response;
        try {
            List<com.example.springboottesting.dao.bean.Customer> customers = customerDao.findAllCustomers();
            response = ResponseEntity.ok().body(customerModelBuilder.buildModelCustomers(customers));
        } catch (Exception e) {
            LOGGER.error(String.format("Error while performing %s", strMethodName), e);
            throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return response;
    }

    public ResponseEntity findCustomerById(UUID customerId) {
        String strMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        ResponseEntity response;
        try {
            com.example.springboottesting.dao.bean.Customer customer = customerDao.findCustomerById(customerId);
            response = ResponseEntity.ok().body(customerModelBuilder.buildModelCustomer(customer));
        } catch (Exception e) {
            LOGGER.error(String.format("Error while performing %s", strMethodName), e);
            throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return response;
    }

    public ResponseEntity createCustomer(Customer customer) {
        String strMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        ResponseEntity response;
        try {
            com.example.springboottesting.dao.bean.Customer cust =
                    customerDaoBuilder.buildDaoCustomer(customer);

            com.example.springboottesting.dao.bean.Customer custResp =
                    customerDao.insertCustomer(cust);

            response = ResponseEntity.ok().body(customerModelBuilder.buildModelCustomer(custResp));

        } catch (Exception e) {
            LOGGER.error(String.format("Error while performing %s", strMethodName), e);
            throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return response;
    }

    public ResponseEntity updateCustomer(Customer customer) {
        String strMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        ResponseEntity response;
        try {
            com.example.springboottesting.dao.bean.Customer cust =
                    customerDaoBuilder.buildDaoCustomer(customer);

            com.example.springboottesting.dao.bean.Customer custResp =
                    customerDao.updateCustomer(cust);

            response = ResponseEntity.ok().body(customerModelBuilder.buildModelCustomer(custResp));

        } catch (Exception e) {
            LOGGER.error(String.format("Error while performing %s", strMethodName), e);
            throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return response;
    }


    public ResponseEntity deleteCustomer(UUID customerId) {
        String strMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        ResponseEntity response;
        try {
            customerDao.deleteCustomer(customerId);
            response = ResponseEntity.ok().build();
        } catch (Exception e) {
            LOGGER.error(String.format("Error while performing %s", strMethodName), e);
            throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return response;
    }


}
