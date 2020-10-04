package edu.cloudunt.customers.domain.service;

import edu.cloudunt.customers.domain.dto.Customer;
import edu.cloudunt.customers.repository.CustomersRepository;
import edu.cloudunt.customers.repository.mapper.CustomerMapper;
import edu.cloudunt.customers.repository.model.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entity = CustomerMapper.MAPPER.toEntity(customer);
        entity = this.customersRepository.save(entity);
        customer = CustomerMapper.MAPPER.toCustomer(entity);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<CustomerEntity> entities = this.customersRepository.findAll();
        return CustomerMapper.MAPPER.toCustomers(entities);
    }

    public Optional<Customer> findById(Long id) {
        return this.customersRepository
                .findById(id)
                .map(CustomerMapper.MAPPER::toCustomer);
    }


}
