package com.example.lesson2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lesson2.databinding.FragmentMainBinding;
import com.example.lesson2.databinding.FragmentThridBinding;

import java.util.ArrayList;


public class ThridFragment extends Fragment {

    private FragmentThridBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThridBinding.inflate(LayoutInflater.from(requireContext()),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null){
            ArrayList<String> textview = getArguments().getStringArrayList(SecondFragment.KEY_FOR_BUNDLE);
            binding.textView.setText(textview.get(0) + " " + textview.get(1));
        }
    }
}