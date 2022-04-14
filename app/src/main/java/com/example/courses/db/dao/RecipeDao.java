package com.example.courses.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.courses.db.entity.RecipeEntity;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;


@Dao
public interface RecipeDao {
    @Query("SELECT * FROM recipe")
    LiveData<List<RecipeEntity>> findAll();

    @Transaction
    @Query("SELECT * FROM recipe")
    LiveData<List<RecipeWithProducts>> getRecipeWithProducts();


}
