package com.algorythmia.springbootalgorythmia.controller;


import com.algorythmia.springbootalgorythmia.dao.OrdersRepository;
import com.algorythmia.springbootalgorythmia.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://frolicking-pudding-12f017.netlify.app")
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

    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable("id") Long id, @RequestBody Boolean newStatus) {
        Optional<Order> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setStatus(newStatus);
            orderRepository.save(order);
            return ResponseEntity.ok("Order status updated");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
        }
    }
}

