package com.ragainfotech.customerservice.controller;

import com.ragainfotech.customerservice.Exception.InvalidInputException;
import com.ragainfotech.customerservice.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.ragainfotech.customerservice.testdatagen.TestDataGen.customer;
import static com.ragainfotech.customerservice.testdatagen.TestDataGen.customerRequest;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerService customerService;

    @Test
    void saveCustomer() throws Exception {
        when(customerService.saveCustomer(customerRequest))
                .thenReturn(customer);

        mockMvc.perform(post("/customerService/saveCustomer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"customerId\":\"1002\",\"createdAt\":\"2022-04-08\"}"))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void getExternalIdByCustomerId() throws Exception {
        when(customerService.fetchExternalIdByCustomerId(customerRequest.getCustomerId()))
                .thenReturn(customer.getExternalId());
        mockMvc.perform(get("/customerService/getExernalId/1002")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().string(equalTo(customer.getExternalId())));
    }
}