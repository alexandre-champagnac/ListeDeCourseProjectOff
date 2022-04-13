package com.example.courses.ui.produits;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.courses.R;
import com.example.courses.databinding.FragmentAddProductBinding;

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
}