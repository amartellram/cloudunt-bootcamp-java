package io.tgelias.myfirstapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class PersonController {

    @GetMapping("/person")

    public Person ViewPerson(){

        String[] interests = new String[3];
        interests[0] = "Java";
        interests[1] = "NodeJS";
        interests[2] = "Cloud";

        return new Person("Elias","Tantalean",
                new Education("Universidad Nacional de Trujillo","Ingenieria de Sistemas"), interests );

    }

}
