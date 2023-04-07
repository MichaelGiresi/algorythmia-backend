package com.algorythmia.springbootalgorythmia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_size")
@Data
public class ProductSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "size")
    private String size;
}
