package com.example.springboottesting.controller;

import com.example.springboottesting.helper.ErrorResponseHelper;
import com.example.springboottesting.model.Customer;
import com.example.springboottesting.helper.CustomerHelper;
import com.example.springboottesting.model.ErrorAttributes;
import com.example.springboottesting.validations.ServiceValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerHelper customerHelper;

    @Autowired
    ErrorResponseHelper errorResponseHelper;

    @Autowired
    ServiceValidator serviceValidator;

    @GetMapping(value = "/customers")
    public ResponseEntity findAllCustomers(HttpServletRequest httpServletRequest) {
        String strMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            return customerHelper.findAllCustomers();
        } catch (Exception e) {
            LOGGER.error(String.format("Error while performing %s", strMethodName), e);
            throw e;
        }
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity findCustomerById(HttpServletRequest httpServletRequest, @PathVariable UUID id) {
        String strMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            return customerHelper.findCustomerById(id);
        } catch (Exception e) {
            LOGGER.error(String.format("Error while performing %s", strMethodName), e);
            throw e;
        }
    }

    @PostMapping(value = "/customers")
    public ResponseEntity createCustomer(HttpServletRequest httpServletRequest, @RequestBody Customer customer) {
        String strMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {

            List<ErrorAttributes> errorAttributesList = new ArrayList<>();

            serviceValidator
                    .validateCustomerRequest(customer)
                    .getErrors().parallelStream()
                    .forEach(errorAttribute -> errorAttributesList.add(errorAttribute));

            if (!CollectionUtils.isEmpty(errorAttributesList)) {
                errorResponseHelper.getBadRequestErrorResponse(strMethodName, errorAttributesList);
            }


            return customerHelper.createCustomer(customer);
        } catch (Exception e) {
            LOGGER.error(String.format("Error while performing %s", strMethodName), e);
            throw e;
        }
    }

    @PutMapping(value = "/customers/{id}")
    public ResponseEntity updateCustomer(HttpServletRequest httpServletRequest,
                                         @PathVariable UUID id,
                                         @RequestBody Customer customer) {
        String strMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {

            List<ErrorAttributes> errorAttributesList = new ArrayList<>();

            serviceValidator
                    .validateCustomerRequest(customer)
                    .getErrors().parallelStream()
                    .forEach(errorAttribute -> errorAttributesList.add(errorAttribute));

            if (!CollectionUtils.isEmpty(errorAttributesList)) {
                return errorResponseHelper.getBadRequestErrorResponse(strMethodName, errorAttributesList);
            }

            customer.setId(id);
            return customerHelper.updateCustomer(customer);
        } catch (Exception e) {
            LOGGER.error(String.format("Error while performing %s", strMethodName), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity deleteCustomer(HttpServletRequest httpServletRequest,
                                         @PathVariable UUID id) {
        String strMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            return customerHelper.deleteCustomer(id);
        } catch (Exception e) {
            LOGGER.error(String.format("Error while performing %s", strMethodName), e);
            throw e;
        }
    }

}
