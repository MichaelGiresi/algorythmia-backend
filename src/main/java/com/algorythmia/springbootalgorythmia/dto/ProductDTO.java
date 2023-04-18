package com.algorythmia.springbootalgorythmia.dto;

import com.algorythmia.springbootalgorythmia.entity.ProductCategory;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductDTO {
    private Long id;
    private String sku;
    private String name;
    private int sizeSmall;
    private int sizeMedium;
    private int sizeLarge;
    private int sizeExtraLarge;
    private int sizeExtraExtraLarge;
    private String description;
    private BigDecimal unitPrice;
    private String imageUrl;
    private boolean active;
    private Date dateCreated;
    private Date lastUpdated;
    private ProductCategory category;
}
