package com.ragainfotech.customerservice.service;

import com.ragainfotech.customerservice.Exception.InvalidInputException;
import com.ragainfotech.customerservice.entity.Customer;
import com.ragainfotech.customerservice.model.CustomerRequest;
import com.ragainfotech.customerservice.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static com.ragainfotech.customerservice.testdatagen.TestDataGen.customer;
import static com.ragainfotech.customerservice.testdatagen.TestDataGen.customerRequest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @Test
    void saveCustomerTest() throws InvalidInputException {
        //Given -- customerRequest
        //When
        underTest.saveCustomer(customerRequest);
        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        //Then
        verify(customerRepository).save(customerArgumentCaptor.capture());
        Customer capturedCustomer = customerArgumentCaptor.getValue();
        assertThat(capturedCustomer.getCustomerId()).isEqualTo(1002);
    }

    @Test
    void fetchExternalIdByCustomerIdTest() throws InvalidInputException {
        //Given -- customerRequest.getCustomerId()
        //When
        when(customerRepository.findById(any())).thenReturn(Optional.ofNullable(customer));
        underTest.fetchExternalIdByCustomerId(customerRequest.getCustomerId());
        ArgumentCaptor<Integer> customerArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        //then
        verify(customerRepository).findById(customerArgumentCaptor.capture());
    }

    @Test
    void fetchExternalIdByCustomerIdNotFoundTest() throws InvalidInputException {
        //Given -- customerRequest.getCustomerId()
        //When
        when(customerRepository.findById(any())).thenReturn(Optional.ofNullable(null));
       //then
       assertThatThrownBy(()-> underTest.fetchExternalIdByCustomerId(customerRequest.getCustomerId()))
               .isInstanceOf(InvalidInputException.class);
    }
}