package io.amartellram.myfirstapp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatsController {

    @GetMapping("/cats")
    public List<Cat> findCats() {

        return List.of(new Cat("Michelin", "white"),
                new Cat("Meow", "black"));
    }
}
