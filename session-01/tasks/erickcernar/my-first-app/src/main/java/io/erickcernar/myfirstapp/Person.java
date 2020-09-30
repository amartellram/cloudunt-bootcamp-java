package io.erickcernar.myfirstapp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private ArrayList<Education> education;
//    private Job job;
    private ArrayList interests;


}
