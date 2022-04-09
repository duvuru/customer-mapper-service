package com.ragainfotech.customerservice.controller;

import com.ragainfotech.customerservice.Exception.InvalidInputException;
import com.ragainfotech.customerservice.model.CustomerRequest;
import com.ragainfotech.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerService")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/saveCustomer")
    public ResponseEntity saveCustomer(@RequestBody CustomerRequest customerRequest) throws InvalidInputException {
        customerService.saveCustomer(customerRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/getExernalId/{customerId}")
    public String getExternalIdByCustomerId(@PathVariable int customerId) throws InvalidInputException {
        return customerService.fetchExternalIdByCustomerId(customerId);
    }
}
