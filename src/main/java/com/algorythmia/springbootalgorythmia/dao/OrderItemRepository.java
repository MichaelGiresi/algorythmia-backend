package com.algorythmia.springbootalgorythmia.dao;

import com.algorythmia.springbootalgorythmia.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
