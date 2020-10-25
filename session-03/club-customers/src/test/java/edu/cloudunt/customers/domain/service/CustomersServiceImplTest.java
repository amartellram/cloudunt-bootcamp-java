package edu.cloudunt.customers.domain.service;

import edu.cloudunt.customers.domain.dto.Customer;
import edu.cloudunt.customers.repository.CustomersRepository;
import edu.cloudunt.customers.repository.model.CustomerEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
public class CustomersServiceImplTest {

    @MockBean
    private CustomersRepository customersRepository;

    private CustomersService customersService;

    @BeforeEach
    void setUp() {
        this.customersService = new CustomersServiceImpl(customersRepository);
    }


    @Test
    public void findAll() {

        CustomerEntity entity = new CustomerEntity();
        entity.setFirstName("Abel");

        Mockito.when(customersRepository.findAll()).thenReturn(List.of(entity));

        List<Customer> customers = customersService.findAll();

        Mockito.verify(customersRepository, Mockito.times(1)).findAll();

        Assertions.assertEquals("Abel", customers.get(0).getFirstName());
    }
}