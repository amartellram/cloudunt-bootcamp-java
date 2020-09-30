package io.erickcernar.myfirstapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @GetMapping("/me")
    public List<Person> listAll() {

        ArrayList<Education> education = new ArrayList<>();
        education.add(new Education("Universidad Nacional de Trujillo", "Ingenieria de Sistemas"));

//        Job job = new Job("Cerflo", "Student");

        ArrayList<String> interests = new ArrayList<>();
        interests.add("Java");
        interests.add("JavaScript");

        return List.of(new Person("Erick", "Cerna", education, interests));
//        return List.of(new Person("Erick", "Cerna", education, job, interests));

    }
}
