package com.algorythmia.springbootalgorythmia.controller;

import com.algorythmia.springbootalgorythmia.dao.ProductRepository;
import com.algorythmia.springbootalgorythmia.entity.Order;
import com.algorythmia.springbootalgorythmia.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;



    @PostMapping("/")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        Product createdProduct = productRepository.save(product);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Product created");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return ResponseEntity.ok("Product with ID " + id + " has been deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with ID " + id + " not found.");
        }
    }

}
