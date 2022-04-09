package com.ragainfotech.customerservice.service;

import com.ragainfotech.customerservice.Exception.InvalidInputException;
import com.ragainfotech.customerservice.entity.Customer;
import com.ragainfotech.customerservice.mapper.CustomerMapper;
import com.ragainfotech.customerservice.model.CustomerRequest;
import com.ragainfotech.customerservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public Customer saveCustomer(CustomerRequest customerRequest) throws InvalidInputException {
        Customer customer = CustomerMapper.mapCustomerReqToCustomer(customerRequest);
        return customerRepository.save(customer);
    }

    public String fetchExternalIdByCustomerId(int customerId) throws InvalidInputException {
        try{
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        return customer.getExternalId();
        }catch (Exception e){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("errorMessage","No record found for the customer Id: "+customerId);
            throw new InvalidInputException(errorMap);
        }
    }
}
