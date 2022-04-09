package com.ragainfotech.customerservice.Exception;

import java.util.Map;

public class InvalidInputException extends Exception{

    Map<String, String> errorMap;

    public InvalidInputException(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }
}
