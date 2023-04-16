package com.algorythmia.springbootalgorythmia.controller;

import com.algorythmia.springbootalgorythmia.entity.ShippingAddress;
import com.algorythmia.springbootalgorythmia.dao.ShippingAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/shippingAddress")
public class ShippingAddressController {

    @Autowired
    private ShippingAddressRepository shippingAddressRepository;

    @GetMapping("/")
    public List<ShippingAddress> getAllShippingAddress() {
        return shippingAddressRepository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<String> createShippingAddress(@RequestBody ShippingAddress shippingAddress) {
        shippingAddressRepository.save(shippingAddress);
        return ResponseEntity.ok("ShippingAddress created");}

}
