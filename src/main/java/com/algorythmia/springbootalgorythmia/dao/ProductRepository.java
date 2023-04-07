package com.algorythmia.springbootalgorythmia.dao;

import com.algorythmia.springbootalgorythmia.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
