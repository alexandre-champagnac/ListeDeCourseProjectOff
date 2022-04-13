package com.example.courses.ui.produits;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;


import com.example.courses.databinding.FragmentProductListBinding;
import com.example.courses.db.AppDatabase;
import com.example.courses.db.dao.ProductDao;

public class ProductsListFragment extends Fragment {

    private FragmentProductListBinding binding;
    private ProductDao productDao;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProductListBinding.inflate(inflater, container, false);

        productDao = AppDatabase.getInstance(getContext()).productDao();

        binding.list.addItemDecoration(new DividerItemDecoration(binding.list.getContext(), DividerItemDecoration.VERTICAL));

        binding.fabCreateNewProduct.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(ProductsListFragmentDirections.actionNavGestionProduitToAddProductFragment());
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ProductRecyclerViewAdapter adapter = new ProductRecyclerViewAdapter();

        productDao.findAll().observe(getViewLifecycleOwner(), productEntities -> {
            adapter.setProducts(productEntities);
        });

        binding.list.setAdapter(adapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int productIndex = viewHolder.getAbsoluteAdapterPosition();
                productDao.deleteById(adapter.getProductAt(productIndex).getProductId());
                adapter.notifyItemRemoved(productIndex);
                Toast.makeText(getActivity(), "Product deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(binding.list);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}