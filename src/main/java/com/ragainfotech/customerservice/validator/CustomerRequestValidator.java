package com.ragainfotech.customerservice.validator;

import com.ragainfotech.customerservice.Exception.InvalidInputException;
import com.ragainfotech.customerservice.model.CustomerRequest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CustomerRequestValidator {
    public static boolean isValidCustomerRequest(CustomerRequest customerRequest) throws InvalidInputException {
        Map<String, String> errorMap = new HashMap<>();
        LocalDate today = LocalDate.now();
        //customerId
        if (customerRequest.getCustomerId() == null)
            errorMap.put("customerId", "CustomerId cannot be null or blank");
        //createdAt
        if (customerRequest.getCreatedAt() == null
                || customerRequest.getCreatedAt().isAfter(today)
                || customerRequest.getCreatedAt().isEqual(today))
            errorMap.put("createdAt", "CreatedAt date has to be in the past");
        //If No errors then it is valid CustomerRequest
        if (errorMap.isEmpty()) {
            return true;
        } else
            throw new InvalidInputException(errorMap);
    }
}
