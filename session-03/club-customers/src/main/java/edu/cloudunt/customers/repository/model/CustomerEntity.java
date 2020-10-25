package edu.cloudunt.customers.repository.model;

import edu.cloudunt.customers.domain.dto.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String mobilePhone;
}
