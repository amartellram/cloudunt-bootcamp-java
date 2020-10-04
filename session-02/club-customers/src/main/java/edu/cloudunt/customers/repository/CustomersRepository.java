package edu.cloudunt.customers.repository;

import edu.cloudunt.customers.repository.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<CustomerEntity, Long> {
}
