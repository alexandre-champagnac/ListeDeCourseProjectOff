package com.example.courses.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.courses.db.entity.ProductEntity;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM products")
    LiveData<List<ProductEntity>> findAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    ListenableFuture<List<Long>> insertAll(List<ProductEntity> products);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    ListenableFuture<Long> insert(ProductEntity productEntity);

    @Query("select * from products where productId = :productId")
    LiveData<ProductEntity> findById(long productId);

    @Query("delete from products where productId = :productId")
    ListenableFuture<Integer> deleteById(long productId);


}