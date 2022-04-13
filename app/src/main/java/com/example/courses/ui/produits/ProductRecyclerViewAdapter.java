package com.example.courses.ui.produits;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courses.databinding.FragmentProductBinding;
import com.example.courses.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder> {

    private List<Product> products = new ArrayList<>();

    public ProductRecyclerViewAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = products.get(position);
        holder.productNameTextView.setText(products.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(List<? extends Product> products) {
        this.products = new ArrayList<>(products);
        notifyDataSetChanged();
    }

    public Product getProductAt(int absoluteAdapterPosition) {
        return products.get(absoluteAdapterPosition);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView productNameTextView;
        public Product mItem;

        public ViewHolder(FragmentProductBinding binding) {
            super(binding.getRoot());
            productNameTextView = binding.productName;
        }

        @NonNull
        @Override
        public String toString() {
            return super.toString() + " '" + productNameTextView.getText() + "'";
        }
    }
}