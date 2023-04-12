package com.algorythmia.springbootalgorythmia.util;

import com.algorythmia.springbootalgorythmia.entity.ProductCategory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class ProductCategoryDeserializer extends JsonDeserializer<ProductCategory> {

    @Override
    public ProductCategory deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Long id = jsonParser.readValueAs(Long.class);
        System.out.println("Deserializing ProductCategory with id: " + id);
        ProductCategory category = new ProductCategory();
        category.setId(id);
        return category;
    }
}
