package com.naca.maplecrystalcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.naca.maplecrystalcalculator.databinding.BossMainBinding;
import com.naca.maplecrystalcalculator.ui.fragment.Boss_Fragment;

public class MainActivity extends AppCompatActivity {

    private BossMainBinding binding;
    private FragmentManager fragmentManager;
    private Boss_Fragment fragment;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        fragment = new Boss_Fragment();

        transaction = fragmentManager.beginTransaction();
        transaction.replace(binding.frame.getId(), fragment).commitAllowingStateLoss();
    }
}