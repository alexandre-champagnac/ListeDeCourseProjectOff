package com.example.courses.ui.produits;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.courses.R;
import com.example.courses.databinding.FragmentAddProductBinding;
import com.example.courses.db.AppDatabase;
import com.example.courses.db.entity.ProductEntity;

public class AddProductFragment extends Fragment {
    private FragmentAddProductBinding binding;

    public AddProductFragment() {
        // Required empty public constructor
    }

    public static AddProductFragment newInstance() {
        return new AddProductFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddProductBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button buttonAddProduct = binding.buttonAddProduct;

        TextView productNameTextView = binding.productNameTextEdit;

        buttonAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductEntity productEntity = new ProductEntity();


                productEntity.setName(productNameTextView.getText().toString());

                AppDatabase.getInstance(getContext()).productDao().insert(productEntity);


                Navigation.findNavController(view).navigate(AddProductFragmentDirections.actionAddProductFragmentToNavGestionProduit());
            }
        });

    }
}