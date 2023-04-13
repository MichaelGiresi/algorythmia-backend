package com.algorythmia.springbootalgorythmia.dao;

import com.algorythmia.springbootalgorythmia.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
