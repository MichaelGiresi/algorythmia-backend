package com.algorythmia.springbootalgorythmia.controller;


import com.algorythmia.springbootalgorythmia.dao.BillingAddressRepository;
import com.algorythmia.springbootalgorythmia.entity.BillingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/billingAddress")
public class BillingAddressController {

    @Autowired
    private BillingAddressRepository billingAddressRepository;

    @GetMapping("/")
    public List<BillingAddress> getAllBillingAddress() {
        return billingAddressRepository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<String> createBillingAddress(@RequestBody BillingAddress billingAddress) {
        billingAddressRepository.save(billingAddress);
        return ResponseEntity.ok("BillingAddress created");}
}
