package com.ragainfotech.customerservice.mapper;

import com.ragainfotech.customerservice.Exception.InvalidInputException;
import com.ragainfotech.customerservice.entity.Customer;
import com.ragainfotech.customerservice.model.CustomerRequest;
import com.ragainfotech.customerservice.validator.CustomerRequestValidator;

import java.util.UUID;

public class CustomerMapper {

    public static Customer mapCustomerReqToCustomer(CustomerRequest customerRequest) throws InvalidInputException {
        Customer customer = null;
        if (CustomerRequestValidator.isValidCustomerRequest(customerRequest)) {
             customer = Customer.builder()
                    .customerId(customerRequest.getCustomerId())
                    .externalId(UUID.randomUUID().toString())
                    .createdAt(customerRequest.getCreatedAt())
                    .build();
        }
        return customer;
    }

}
