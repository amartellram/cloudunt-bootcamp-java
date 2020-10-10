package io.erickcernar.mysecondapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private String userId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String mobilePhone;

}
