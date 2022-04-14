package com.example.courses.db;

import com.example.courses.db.dao.RecipeWithProducts;
import com.example.courses.db.entity.ProductEntity;
import com.example.courses.db.entity.RecipeEntity;

import java.util.ArrayList;
import java.util.List;

public class MockedDataGenerator {

    private static final String[] Products = new String[]{
            "Poulet", "Chips", "Curry", "Saumon", "Pomme de terre"};

    private static final String[] Recipes = new String[]{
            "Purée et saumon", "Chips au curry"};



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

    public static List<RecipeWithProducts> generateRecipes(List<ProductEntity> products) {
        List<RecipeWithProducts> recipes = new ArrayList<>(Recipes.length);

        for(int i = 0; i < Recipes.length; i++){
            RecipeWithProducts rwp = new RecipeWithProducts();

            RecipeEntity recipeEntity = new RecipeEntity();
            recipeEntity.setName(Recipes[i]);

            rwp.setRecipe(recipeEntity);
            rwp.setProducts(products);

            recipes.add(rwp);

        }
        return recipes;
    }



}
