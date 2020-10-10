package io.erickcernar.mysecondapp.web;

import io.erickcernar.mysecondapp.domain.dto.User;
import io.erickcernar.mysecondapp.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService usersService;

    @GetMapping("v1/users")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(this.usersService.findAll(), HttpStatus.OK);
    }

    @PostMapping("v1/users")
    public ResponseEntity<User> save(@RequestBody User user) {
        var optionalUser = this.usersService.save(user);
        return new ResponseEntity<>(optionalUser, HttpStatus.CREATED);
    }

    @PutMapping("v1/users")
    public ResponseEntity<User> update(@RequestBody User user) {

        var optionalUser = this.usersService.update(user);

        return new ResponseEntity<>(optionalUser, HttpStatus.OK);
//        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("v1/users/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var optionalUser = this.usersService.findById(id);
        return optionalUser.map(
                customer -> new ResponseEntity<>(customer, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("v1/users/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        var optionalUser = this.usersService.findById(id);

        if (optionalUser.isPresent()){
            this.usersService.deleteById(id);
        }
        else {
//            System.out.println("Not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

    }

}
