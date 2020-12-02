package com.naca.bible;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Verse_Main extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private Verse_Fragment fragment;
    private FragmentTransaction transaction;
    private ImageView imageview_prev;
    private ImageView imageview_next;
    private TextView TextView_name_verse;

    private int chapter;
    private String bible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verse_main);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        fragmentManager = getSupportFragmentManager();
        fragment = new Verse_Fragment();

        fragment.setArguments(bundle);

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame, fragment).commitAllowingStateLoss();

        imageview_prev = findViewById(R.id.imageview_prev);
        imageview_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickhandler(v);
            }
        });

        imageview_next = findViewById(R.id.imageview_next);
        imageview_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickhandler(v);
            }
        });

        TextView_name_verse = findViewById(R.id.name_verse);
        TextView_name_verse.setText(bundle.getString("chapter").substring(3) + " " + Integer.toString(bundle.getInt("verse") +1) + "장");

    }

    public void clickhandler(View View){
        transaction = fragmentManager.beginTransaction();

        switch (View.getId()){
            case R.id.imageview_prev:
//                transaction.replace(R.id.frame, fragment_old).commitAllowingStateLoss();
                break;
            case R.id.imageview_next:
//                transaction.replace(R.id.frame, fragment_new).commitAllowingStateLoss();
                break;
        }
    }
}