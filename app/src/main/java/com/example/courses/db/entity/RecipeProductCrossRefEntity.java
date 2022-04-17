package com.example.courses.db.entity;


import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "recipe_product", primaryKeys = {"recipeId", "productId"})
public class RecipeProductCrossRefEntity {
    @NonNull
    private Long recipeId;
    @NonNull
    private Long productId;

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public RecipeProductCrossRefEntity(){

    }
}
