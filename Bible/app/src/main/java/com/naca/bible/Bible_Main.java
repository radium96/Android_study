package com.naca.bible;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.naca.bible.databinding.BibleMainBinding;
import com.naca.bible.ui.viewModel.BibleViewModel;

public class Bible_Main extends AppCompatActivity {

    private BibleMainBinding binding;

    private FragmentManager fragmentManager;
    private Bible_Fragment_old fragment_old;
    private Bible_Fragment_new fragment_new;
    private FragmentTransaction transaction;
    private Button bible_old;
    private Button bible_new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.bible_main);
        binding.setViewmodel(new BibleViewModel());

        fragmentManager = getSupportFragmentManager();

        fragment_old = new Bible_Fragment_old();
        fragment_new = new Bible_Fragment_new();

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame, fragment_old).commitAllowingStateLoss();

        bible_old = findViewById(R.id.bible_old);
        bible_old.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickhandler(v);
            }
        });

        bible_new = findViewById(R.id.bible_new);
        bible_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickhandler(v);
            }
        });
    }

    public void clickhandler(View View){
        transaction = fragmentManager.beginTransaction();

        switch (View.getId()){
            case R.id.bible_old:
                transaction.replace(R.id.frame, fragment_old).commitAllowingStateLoss();
                break;
            case R.id.bible_new:
                transaction.replace(R.id.frame, fragment_new).commitAllowingStateLoss();
                break;
        }
    }
}