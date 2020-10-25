package edu.cloudunt.customers.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    private static final long serialVersionUID = -5031441949746098107L;
    private String customerId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String mobilePhone;

}
