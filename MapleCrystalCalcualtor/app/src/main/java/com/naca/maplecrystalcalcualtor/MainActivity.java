package com.naca.maplecrystalcalcualtor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.naca.maplecrystalcalcualtor.databinding.BossMainBinding;

public class MainActivity extends AppCompatActivity {

    BossMainBinding binding;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();




    }
}