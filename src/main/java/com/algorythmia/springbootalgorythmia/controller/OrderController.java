package com.algorythmia.springbootalgorythmia.controller;


import com.algorythmia.springbootalgorythmia.dao.OrdersRepository;
import com.algorythmia.springbootalgorythmia.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrdersRepository orderRepository;

    @GetMapping("/")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        orderRepository.save(order);
        return ResponseEntity.ok("Order created");}
}
