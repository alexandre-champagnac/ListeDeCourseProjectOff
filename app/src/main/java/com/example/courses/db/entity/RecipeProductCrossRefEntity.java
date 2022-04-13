package com.example.courses.db.entity;


import androidx.room.Entity;

@Entity(tableName = "recipe_product", primaryKeys = {"recipeId", "productId"})
public class RecipeProductCrossRefEntity {

    private long recipeId;
    private long productId;

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public RecipeProductCrossRefEntity(){

    }
}
