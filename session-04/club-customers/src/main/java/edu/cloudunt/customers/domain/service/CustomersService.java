package edu.cloudunt.customers.domain.service;

import edu.cloudunt.customers.domain.dto.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomersService {

    Customer save(Customer customer);
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer update(Customer customer);
    void delete(Long id);

}
