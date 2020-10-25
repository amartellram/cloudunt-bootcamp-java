package edu.cloudunt.customers.repository;

import edu.cloudunt.customers.domain.dto.Customer;
import edu.cloudunt.customers.repository.model.CustomerEntity;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CustomersRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomersRepository repository;

    @Test
    void findByFirstName() {
        var searchName = "Abel";
        var firstCustomer = new CustomerEntity();
        firstCustomer.setFirstName(searchName);
        firstCustomer.setLastName("Martell");

        var secondCustomer = new CustomerEntity();
        secondCustomer.setFirstName(searchName);
        secondCustomer.setLastName("Martinez");

        this.entityManager.persist(firstCustomer);
        this.entityManager.persist(secondCustomer);

        List<CustomerEntity> customers = repository.findByFirstName(searchName);

        assertThat( customers.size()).isEqualTo(2);
        assertThat(customers).extracting(CustomerEntity::getLastName)
                            .contains("Martell");


    }
}