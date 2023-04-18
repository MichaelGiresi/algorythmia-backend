package com.algorythmia.springbootalgorythmia.entity;

import com.algorythmia.springbootalgorythmia.util.ProductCategoryDeserializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
//    @JsonDeserialize(using = ProductCategoryDeserializer.class)
//    @JsonBackReference
    private ProductCategory category;

    @Column(name = "sku")
    private String sku;
    @Column(name = "name")
    private String name;
    
    @Column(name = "size_small")
    private int sizeSmall;

    @Column(name = "size_medium")
    private int sizeMedium;

    @Column(name = "size_large")
    private int sizeLarge;

    @Column(name = "size_extra_large")
    private int sizeExtraLarge;

    @Column(name = "size_extra_extra_large")
    private int sizeExtraExtraLarge;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "active")
    private boolean active;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;


}
