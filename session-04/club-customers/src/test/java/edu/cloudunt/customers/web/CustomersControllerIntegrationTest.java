package edu.cloudunt.customers.web;

import edu.cloudunt.customers.client.NotificationFeignClient;
import edu.cloudunt.customers.client.dto.NotificationResponse;
import edu.cloudunt.customers.domain.dto.Customer;
import edu.cloudunt.customers.domain.dto.Gender;
import edu.cloudunt.customers.repository.CustomersRepository;
import edu.cloudunt.customers.repository.model.CustomerEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomersControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private CustomersRepository customersRepository;

    @MockBean
    private NotificationFeignClient notificationFeignClient;

    private MockMvc mockMvc;

    @BeforeAll
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

    }

    @Test
    @Disabled
    void save() throws Exception {
        CustomerEntity customer = new CustomerEntity();
        customer.setFirstName("Abel");
        customer.setLastName("Martell");
        customer.setGender(Gender.MALE);
        customer.setEmail("amartellram@gmail.com");
        customer.setMobilePhone("123456789");
        customer.setId(1L);

        Mockito.when(customersRepository.save(Mockito.any())).thenReturn(customer);
        Mockito.when(notificationFeignClient.send(Mockito.any())).thenReturn(new NotificationResponse());

        String jsonRequest = new String(Files.readAllBytes(Paths.get(getClass().getResource("/customer.json").toURI())));

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/v1/customers" )
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andDo(print()).andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.customerId").value("1"));

    }
}