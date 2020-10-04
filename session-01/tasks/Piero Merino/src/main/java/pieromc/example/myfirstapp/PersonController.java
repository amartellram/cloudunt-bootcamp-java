package pieromc.example.myfirstapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PersonController {
    
    @GetMapping("/student")

    public Person getPerson() {
        
        String[] interests = new String[3];
        interests[0] = "Java";
        interests[1] = "NodeJS";
        interests[2] = "Cloud";
        
        Person person = new Person("Piero", "Merino", new Education("UNT", "Sistemas"), interests);
        return person;
    }

}
