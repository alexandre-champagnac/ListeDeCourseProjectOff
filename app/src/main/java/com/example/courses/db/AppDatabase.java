package com.example.courses.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.courses.db.dao.ProductDao;
import com.example.courses.db.dao.RecipeDao;
import com.example.courses.db.entity.ProductEntity;
import com.example.courses.db.entity.RecipeEntity;
import com.example.courses.db.entity.RecipeProductCrossRefEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ProductEntity.class, RecipeEntity.class, RecipeProductCrossRefEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase sInstance;

    @VisibleForTesting
    public static final String DATABASE_NAME = "basic-sample-db";

    public abstract ProductDao productDao();
    public abstract RecipeDao recipeDao();

    public static AppDatabase getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = buildDatabase(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private static AppDatabase buildDatabase(final Context appContext) {
        return Room.databaseBuilder(appContext, AppDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        AppDatabase database = AppDatabase.getInstance(appContext);

                        database.productDao().insertAll(MockedDataGenerator.generateProducts());




                        RecipeEntity recipe1 = new RecipeEntity();
                        recipe1.setName("Chutney de fruits");

                        database.recipeDao().insert(recipe1);



                        RecipeProductCrossRefEntity r1 = new RecipeProductCrossRefEntity();

                        r1.setRecipeId(1L);
                        r1.setProductId(1L);

                        RecipeProductCrossRefEntity r2 = new RecipeProductCrossRefEntity();

                        r2.setRecipeId(1L);

                        r2.setProductId(2L);

                        List<RecipeProductCrossRefEntity> listRecipeProductCrossRefEntiry = new ArrayList<>();

                        listRecipeProductCrossRefEntiry.add(r1);
                        listRecipeProductCrossRefEntiry.add(r2);






                        database.recipeDao().insertAllRecipeProductCrossRef(listRecipeProductCrossRefEntiry);
                    }
                })
                .build();
    }

}
