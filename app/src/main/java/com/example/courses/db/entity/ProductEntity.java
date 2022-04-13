package com.example.courses.db.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.courses.model.Product;

@Entity(tableName = "products")
public class ProductEntity implements Product {
    @PrimaryKey
    private long id;
    private String name;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductEntity() {
    }

    @Ignore
    public ProductEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductEntity(Product product) {
        this.id = product.getId();
        this.name = product.getName();
    }
}
