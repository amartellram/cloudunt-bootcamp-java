package edu.cloudunt.customers.domain.service;

import edu.cloudunt.customers.client.NotificationFeignClient;
import edu.cloudunt.customers.client.dto.NotificationRequest;
import edu.cloudunt.customers.client.dto.NotificationResponse;
import edu.cloudunt.customers.domain.dto.Customer;
import edu.cloudunt.customers.repository.CustomersRepository;
import edu.cloudunt.customers.repository.mapper.CustomerMapper;
import edu.cloudunt.customers.repository.model.CustomerEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomersServiceImpl implements CustomersService {

    private final CustomersRepository customersRepository;
    private final NotificationFeignClient notificationClient;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entity = CustomerMapper.MAPPER.toEntity(customer);
        entity = this.customersRepository.save(entity);
        customer = CustomerMapper.MAPPER.toCustomer(entity);
        this.sendMessage(customer);
        return customer;
    }

    private void sendMessage(Customer customer) {
        NotificationRequest request = new NotificationRequest();
        request.setEmail(customer.getEmail());
        request.setDescription(customer.getFirstName() + ", Welcome!!");
        request.setMessage("Welcome to CloudUNT Bootcamps!");
        NotificationResponse response = this.notificationClient.send(request);
        this.log.info(response.getMessage());
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
