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

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order orderId;

    @ManyToOne
    @JoinColumn (name = "product_id", nullable = false)
    private Product productId;

    @ManyToOne
    @JoinColumn (name = "size_id", nullable = false)
    private ProductSize sizeId;

}
