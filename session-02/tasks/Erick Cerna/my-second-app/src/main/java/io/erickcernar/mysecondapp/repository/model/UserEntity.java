package io.erickcernar.mysecondapp.repository.model;

import io.erickcernar.mysecondapp.domain.dto.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String mobilePhone;

}
