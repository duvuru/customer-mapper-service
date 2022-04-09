package com.ragainfotech.customerservice.validator;

import com.ragainfotech.customerservice.Exception.InvalidInputException;
import com.ragainfotech.customerservice.model.CustomerRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.ragainfotech.customerservice.testdatagen.TestDataGen.customerRequest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CustomerRequestValidatorTest {


    @Test
    void isValidCustomerRequest() throws InvalidInputException {
        assertThat(CustomerRequestValidator.isValidCustomerRequest(customerRequest)).isTrue();
    }
    @Test
    void isInValidCustomerRequest() throws InvalidInputException {
        assertThatThrownBy(()-> CustomerRequestValidator.isValidCustomerRequest(new CustomerRequest()))
                .isInstanceOf(InvalidInputException.class);
    }
}