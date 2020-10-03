package com.jhonlivias.myfirstapp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InformationController {
    @GetMapping("/information")
    public List<Information> findInformation() {
        return List.of(new Information("Jhon Livias", "Ing. de Sistemas","java,php,c++"));
    }
}
