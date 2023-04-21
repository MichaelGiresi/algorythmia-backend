package com.algorythmia.springbootalgorythmia.controller;


import com.algorythmia.springbootalgorythmia.dao.CustomerRepository;
import com.algorythmia.springbootalgorythmia.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "https://frolicking-pudding-12f017.netlify.app")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return ResponseEntity.ok("Customer created");}
}
