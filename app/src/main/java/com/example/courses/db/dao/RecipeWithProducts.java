package com.example.courses.db.dao;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.courses.db.entity.ProductEntity;
import com.example.courses.db.entity.RecipeEntity;
import com.example.courses.db.entity.RecipeProductCrossRefEntity;
import com.example.courses.model.Product;

import java.util.List;

public class RecipeWithProducts {
    @Embedded
    private RecipeEntity recipe;
    @Relation(
            parentColumn = "recipeId",
            entityColumn = "productId",
            associateBy = @Junction(RecipeProductCrossRefEntity.class)
    )
    private List<ProductEntity> products;

    public RecipeEntity getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public RecipeWithProducts() {
    }
}
