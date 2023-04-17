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
import java.util.Optional;

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

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductSizeQuantities(@PathVariable Long id, @RequestBody Map<String, Integer> sizeQuantities) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();

            if (sizeQuantities.containsKey("sizeSmall")) {
                existingProduct.setSizeSmall(sizeQuantities.get("sizeSmall"));
            }
            if (sizeQuantities.containsKey("sizeMedium")) {
                existingProduct.setSizeMedium(sizeQuantities.get("sizeMedium"));
            }
            if (sizeQuantities.containsKey("sizeLarge")) {
                existingProduct.setSizeLarge(sizeQuantities.get("sizeLarge"));
            }
            if (sizeQuantities.containsKey("sizeExtraLarge")) {
                existingProduct.setSizeExtraLarge(sizeQuantities.get("sizeExtraLarge"));
            }
            if (sizeQuantities.containsKey("sizeExtraExtraLarge")) {
                existingProduct.setSizeExtraExtraLarge(sizeQuantities.get("sizeExtraExtraLarge"));
            }

            Product savedProduct = productRepository.save(existingProduct);
            return new ResponseEntity<>(savedProduct, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with ID " + id + " not found.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
