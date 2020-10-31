package edu.cloudunt.customers.web;

import edu.cloudunt.customers.domain.dto.Customer;
import edu.cloudunt.customers.domain.service.CustomersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest
@AutoConfigureMockMvc
class CustomersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomersService customersService;

    @Test
    void findAll() throws Exception {

        var customer = new Customer();
        customer.setCustomerId("1234567");
        customer.setFirstName("Abel");
        customer.setLastName("Martell");

        Mockito.when(customersService.findAll()).thenReturn(List.of(customer));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customers"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(customersService, Mockito.times(1)).findAll();
    }
}