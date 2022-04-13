package com.example.courses.db.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.courses.model.Product;

@Entity(tableName = "products")
public class ProductEntity implements Product {
    @PrimaryKey
    private long productId;
    private String name;

    @Override
    public long getProductId() {
        return productId;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductEntity() {
    }

    @Ignore
    public ProductEntity(long productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public ProductEntity(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
    }
}
