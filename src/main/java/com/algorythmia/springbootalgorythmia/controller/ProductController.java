package com.algorythmia.springbootalgorythmia.controller;

import com.algorythmia.springbootalgorythmia.dao.ProductRepository;
import com.algorythmia.springbootalgorythmia.dto.ProductDTO;
import com.algorythmia.springbootalgorythmia.entity.Order;
import com.algorythmia.springbootalgorythmia.entity.Product;
import com.algorythmia.springbootalgorythmia.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Map<String, Object> updates) throws IllegalAccessException, InvocationTargetException {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();

            for (Map.Entry<String, Object> entry : updates.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();
                Field field = ReflectionUtils.findField(Product.class, fieldName);
                if (field != null) {
                    field.setAccessible(true);
                    if (field.getType().equals(BigDecimal.class) && (fieldValue instanceof String || fieldValue instanceof Number)) {
                        fieldValue = new BigDecimal(fieldValue.toString());
                    } else if (field.getType().equals(ProductCategory.class) && fieldValue instanceof Map) {
                        Map<String, Object> categoryMap = (Map<String, Object>) fieldValue;
                        ProductCategory category = new ProductCategory();
                        category.setId(((Number) categoryMap.get("id")).longValue());
                        fieldValue = category;
                    } else if (field.getType().equals(int.class) && fieldValue instanceof String) {
                        fieldValue = Integer.parseInt((String) fieldValue);
                    }
                    field.set(existingProduct, fieldValue);
                }
            }

            Product savedProduct = productRepository.save(existingProduct);
            return new ResponseEntity<>(savedProduct, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with ID " + id + " not found.");
        }
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
//        Optional<Product> productOptional = productRepository.findById(id);
//        if (productOptional.isPresent()) {
//            return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = products.stream()
                .map(this::toProductDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            ProductDTO productDTO = toProductDTO(productOptional.get());
            return new ResponseEntity<>(productDTO, HttpStatus.OK);
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
    public ProductDTO toProductDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setSku(product.getSku());
        dto.setName(product.getName());
        dto.setSizeSmall(product.getSizeSmall());
        dto.setSizeMedium(product.getSizeMedium());
        dto.setSizeLarge(product.getSizeLarge());
        dto.setSizeExtraLarge(product.getSizeExtraLarge());
        dto.setSizeExtraExtraLarge(product.getSizeExtraExtraLarge());
        dto.setDescription(product.getDescription());
        dto.setUnitPrice(product.getUnitPrice());
        dto.setImageUrl(product.getImageUrl());
        dto.setActive(product.isActive());
        dto.setDateCreated(product.getDateCreated());
        dto.setLastUpdated(product.getLastUpdated());
        dto.setCategory(product.getCategory());
        return dto;
    }


}
