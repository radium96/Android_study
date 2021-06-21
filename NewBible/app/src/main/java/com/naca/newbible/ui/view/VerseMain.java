package com.naca.newbible.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.naca.newbible.R;
import com.naca.newbible.databinding.VerseMainBinding;

public class VerseMain extends AppCompatActivity {

    private VerseMainBinding binding;

    private FragmentManager fragmentManager;
    private VerseFragment fragmentNow;
    private VerseFragment fragmentChange;
    private VerseFragment temp;
    private FragmentTransaction transaction;

    private int chapter;
    private String bible;
    private int chapterNum;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.verse_main);
        binding.setLifecycleOwner(this);

        fragmentManager = getSupportFragmentManager();

        fragmentNow = new VerseFragment();
        fragmentChange = new VerseFragment();

        transaction = fragmentManager.beginTransaction();
        transaction.replace(binding.verseFrame.getId(), fragmentNow).commitAllowingStateLoss();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        fragmentNow.setArguments(bundle);

        bible = bundle.getString("chapter").substring(3);
        chapter = bundle.getInt("verse") + 1;
        path = bundle.getString("path");
        binding.bibleName.setText(bible + " " + Integer.toString(chapter) + "장");

        chapterNum = bundle.getInt("numVerse");
        binding.verseNum.setText(Integer.toString(chapter) + "/" + Integer.toString(chapterNum));

        binding.prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickhandler(v);
            }
        });

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickhandler(v);
            }
        });

    }

    public void clickhandler(View View){
        transaction = fragmentManager.beginTransaction();

        if (binding.prev.equals(View)) {
            if (chapter > 1) {
                chapter--;
                binding.bibleName.setText(bible + " " + Integer.toString(chapter) + "장");
                binding.verseNum.setText(Integer.toString(chapter) + "/" + Integer.toString(chapterNum));
                Bundle b = new Bundle();
                b.putString("path", path);
                b.putInt("verse", chapter - 1);
                fragmentChange.setArguments(b);
                transaction.replace(binding.verseFrame.getId(), fragmentChange).commitAllowingStateLoss();
                temp = fragmentNow;
                fragmentNow = fragmentChange;
                fragmentChange = temp;
            }
        } else if (binding.next.equals(View)) {
            if (chapter < chapterNum) {
                chapter++;
                binding.bibleName.setText(bible + " " + Integer.toString(chapter) + "장");
                binding.verseNum.setText(Integer.toString(chapter) + "/" + Integer.toString(chapterNum));
                Bundle b = new Bundle();
                b.putString("path", path);
                b.putInt("verse", chapter - 1);
                fragmentChange.setArguments(b);
                transaction.replace(binding.verseFrame.getId(), fragmentChange).commitAllowingStateLoss();
                temp = fragmentNow;
                fragmentNow = fragmentChange;
                fragmentChange = temp;
            }
        }
    }
}