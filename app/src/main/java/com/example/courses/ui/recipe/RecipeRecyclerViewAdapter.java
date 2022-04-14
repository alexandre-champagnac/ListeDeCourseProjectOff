package com.example.courses.ui.recipe;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.courses.databinding.FragmentRecipeBinding;
import com.example.courses.db.entity.RecipeEntity;


import java.util.ArrayList;
import java.util.List;


public class RecipeRecyclerViewAdapter extends RecyclerView.Adapter<RecipeRecyclerViewAdapter.ViewHolder> {

    private  List<RecipeEntity> recipes;

    public RecipeRecyclerViewAdapter() {
        recipes = new ArrayList<>();
    }

    public void setRecipe(List<RecipeEntity> recipes) {
        this.recipes = recipes;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentRecipeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.recipename.setText(recipes.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView recipename;


        public ViewHolder(FragmentRecipeBinding binding) {
            super(binding.getRoot());
            recipename = binding.recipename;

        }

    }
}