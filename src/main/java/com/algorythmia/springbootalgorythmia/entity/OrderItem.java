package com.algorythmia.springbootalgorythmia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_items")
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "quantity")
    private long quantity;

    @Column (name = "unit_price")
    private double unitPrice;

    @Column (name = "order_id")
    private int orderId;

    @Column (name = "product_id")
    private int productId;

    @Column (name = "size_id")
    private int sizeId;

}
