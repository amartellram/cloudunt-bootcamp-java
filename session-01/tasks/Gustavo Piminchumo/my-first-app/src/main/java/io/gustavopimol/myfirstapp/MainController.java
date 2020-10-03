package io.gustavopimol.myfirstapp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    @GetMapping("/information")
    public List<Personalinformation> findMain(){
        return List.of(new Personalinformation("Gustavo Piminchumo",
                "Universidad Nacional de Trujillo, " +
                "career: Ingenieria de Sistemas",
                "java, javaScript"));
    }



}
