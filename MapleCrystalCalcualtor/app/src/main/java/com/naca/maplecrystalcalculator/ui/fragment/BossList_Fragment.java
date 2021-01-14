package com.naca.maplecrystalcalculator.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.naca.maplecrystalcalculator.R;
import com.naca.maplecrystalcalculator.databinding.BossRecyclerBinding;

public class BossList_Fragment extends Fragment {

    private BossRecyclerBinding binding;

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.boss_recyclerview, container, false);
        View root = binding.getRoot();



        return root;
    }
}