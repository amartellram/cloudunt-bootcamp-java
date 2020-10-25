package edu.cloudunt.customers.domain.service;

import edu.cloudunt.customers.domain.dto.Customer;
import edu.cloudunt.customers.repository.CustomersRepository;
import edu.cloudunt.customers.repository.mapper.CustomerMapper;
import edu.cloudunt.customers.repository.model.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomersServiceImpl implements CustomersService {

    private final CustomersRepository customersRepository;

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

    @Override
    public Customer update(Customer customer) {
        var customerEntity = CustomerMapper.MAPPER.toEntity(customer);
        return CustomerMapper.MAPPER.toCustomer(this.customersRepository.saveAndFlush(customerEntity));
    }

    @Override
    public void delete(Long id) {
        this.customersRepository.deleteById(id);
    }


}
