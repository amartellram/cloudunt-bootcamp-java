package edu.cloudunt.customers.web;

import edu.cloudunt.customers.domain.dto.Customer;
import edu.cloudunt.customers.domain.service.CustomersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CustomersController {

    private final CustomersService customersService;

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return this.customersService.findAll();
    }

    @PostMapping("/customers")
    public Customer save(@RequestBody Customer customer) {
        return this.customersService.save(customer);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        var optionalCustomer = this.customersService.findById(id);
         return optionalCustomer.map(
                customer -> new ResponseEntity<>(customer, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
