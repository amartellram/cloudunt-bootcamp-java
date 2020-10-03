package io.jesussaavedra.myfirstapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController

public class InformationController {
    @GetMapping("/information")

    public List<Information> Information(){
        Technologies technologie01 = new Technologies("Java");
        Technologies technologie02 = new Technologies("Javascript");
        Technologies technologie03 = new Technologies("Python");
        Technologies technologie04 = new Technologies("Ruby");
        Technologies[] technologies = {technologie01,technologie02,technologie03,technologie04};
        Job job  = new Job("Restaurant Puerto Escondido","Waiter");
        Education education = new Education("Universidad Nacional de Trujillo","Ingenieria de Sistemas");
        Information information = new Information("Jerson Jesus Saavedra Neira",education,job,technologies);
        return List.of(information);
    }
}
