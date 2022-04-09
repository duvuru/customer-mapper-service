package com.ragainfotech.customerservice.mapper;

import com.ragainfotech.customerservice.Exception.InvalidInputException;
import com.ragainfotech.customerservice.entity.Customer;
import com.ragainfotech.customerservice.model.CustomerRequest;
import org.junit.jupiter.api.Test;

import static com.ragainfotech.customerservice.testdatagen.TestDataGen.customerRequest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {

    @Test
    void mapCustomerReqToCustomer() throws InvalidInputException {
        Customer customer = CustomerMapper.mapCustomerReqToCustomer(customerRequest);
        assertThat(customer.getCustomerId()).isEqualTo(customerRequest.getCustomerId());
        assertThat(customer.getCreatedAt()).isEqualTo(customerRequest.getCreatedAt());
    }
}