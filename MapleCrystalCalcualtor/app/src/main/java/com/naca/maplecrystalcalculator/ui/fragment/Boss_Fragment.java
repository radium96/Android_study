package com.naca.maplecrystalcalculator.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.naca.maplecrystalcalculator.R;
import com.naca.maplecrystalcalculator.databinding.CalculatorBinding;

public class Boss_Fragment extends Fragment {

    private CalculatorBinding binding;
    private FragmentManager fragmentManager;
    private BossList_Fragment fragment;
    private FragmentTransaction transaction;

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.calculator_fragment, container, false);
        View root = binding.getRoot();

        fragmentManager = getChildFragmentManager();

        fragment = new BossList_Fragment();

        transaction = fragmentManager.beginTransaction();
        transaction.replace(binding.frame.getId(), fragment).commitAllowingStateLoss();

        return root;
    }
}
