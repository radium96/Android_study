package com.naca.newbible.ui.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.naca.newbible.R;
import com.naca.newbible.databinding.BibleMainBinding;
import com.naca.newbible.ui.viewModel.BibleMainViewModel;

public class BibleMain extends AppCompatActivity {

    private BibleMainBinding binding;
    private BibleMainViewModel appMainViewModel;
    private Button buttonOld;
    private Button buttonNew;

    private FragmentManager fragmentManager;
    private BibleFragmentOld bibleFragmentOld;
    private BibleFragmentNew bibleFragmentNew;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.bible_main);
        binding.setLifecycleOwner(this);

        appMainViewModel = new ViewModelProvider(this).get(BibleMainViewModel.class);

        fragmentManager = getSupportFragmentManager();

        bibleFragmentOld = new BibleFragmentOld();
        bibleFragmentNew = new BibleFragmentNew();

        transaction = fragmentManager.beginTransaction();
        transaction.replace(binding.bibleFrame.getId(), bibleFragmentOld).commitAllowingStateLoss();

        buttonOld = binding.buttonOld;
        buttonOld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(binding.bibleFrame.getId(), bibleFragmentOld).commitAllowingStateLoss();
            }
        });

        buttonNew = binding.buttonNew;
        buttonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(binding.bibleFrame.getId(), bibleFragmentNew).commitAllowingStateLoss();
            }
        });
    }
}
