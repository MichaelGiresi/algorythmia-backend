package com.algorythmia.springbootalgorythmia.dao;

import com.algorythmia.springbootalgorythmia.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {




}
