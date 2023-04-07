package com.algorythmia.springbootalgorythmia.dao;

import com.algorythmia.springbootalgorythmia.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Order, Long> {
}
