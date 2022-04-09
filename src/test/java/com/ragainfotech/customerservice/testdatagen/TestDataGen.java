package com.ragainfotech.customerservice.testdatagen;

import com.ragainfotech.customerservice.entity.Customer;
import com.ragainfotech.customerservice.model.CustomerRequest;

import java.time.LocalDate;
import java.util.UUID;

public class TestDataGen {
    public static CustomerRequest customerRequest = new CustomerRequest(1002, LocalDate.now().minusDays(1));
    public static Customer customer = Customer.builder()
            .customerId(customerRequest.getCustomerId())
            .createdAt(customerRequest.getCreatedAt())
            .externalId(UUID.randomUUID().toString())
            .build();
}
