package com.example.lesson2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lesson2.databinding.FragmentSecondBinding;

import java.util.ArrayList;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    public static final String KEY_FOR_BUNDLE = "KEY_FOR_BUNDLE";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(LayoutInflater.from(requireContext()), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            String tv_one = getArguments().getString(MainFragment.KEY_FOR_BUNDLE);
            binding.textView.setText(tv_one);
        }
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                String a = binding.textView.getText().toString();
                String b = binding.editText.getText().toString();
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(a);
                arrayList.add(b);
                bundle.putStringArrayList(KEY_FOR_BUNDLE,arrayList);
                ThridFragment fragment = new ThridFragment();
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack("").commit();
            }
        });
    }
}