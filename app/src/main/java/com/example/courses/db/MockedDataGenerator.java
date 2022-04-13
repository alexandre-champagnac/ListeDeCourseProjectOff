package com.example.courses.db;

import com.example.courses.db.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public class MockedDataGenerator {

    private static final String[] Products = new String[]{
            "Poulet", "Chips", "Curry", "Saumon", "Pomme de terre"};

    public static List<ProductEntity> generateProducts() {
        List<ProductEntity> products = new ArrayList<>(Products.length);
        for (int i = 0; i < Products.length; i++) {
            ProductEntity product = new ProductEntity();
            product.setProductId(i);
            product.setName(Products[i]);

            products.add(product);
        }
        return products;
    }

}
