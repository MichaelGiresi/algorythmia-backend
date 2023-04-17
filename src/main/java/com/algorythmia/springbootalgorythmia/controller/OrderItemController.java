package com.algorythmia.springbootalgorythmia.controller;


import com.algorythmia.springbootalgorythmia.dao.OrderItemRepository;
import com.algorythmia.springbootalgorythmia.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/orderItems")
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @PostMapping("/")
    public ResponseEntity<String> createOrderItem(@RequestBody OrderItem orderItem) {
        orderItemRepository.save(orderItem);
        return ResponseEntity.ok("OrderItem created");}
}
