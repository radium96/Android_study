package com.naca.newbible.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.naca.newbible.R;
import com.naca.newbible.databinding.AppMainBinding;
import com.naca.newbible.ui.viewModel.AppMainViewModel;

public class AppMain extends AppCompatActivity {

    private AppMainBinding binding;
    private AppMainViewModel appMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.app_main);
        binding.setLifecycleOwner(this);

        appMainViewModel = new ViewModelProvider(this).get(AppMainViewModel.class);

        binding.bible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), BibleMain.class);
                startActivity(intent);
            }
        });

        binding.hymn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.christianity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}