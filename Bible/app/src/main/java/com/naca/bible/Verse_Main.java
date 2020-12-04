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
    private Verse_Fragment fragmentChange;
    private Verse_Fragment temp;
    private FragmentTransaction transaction;
    private ImageView imageview_prev;
    private ImageView imageview_next;
    private TextView TextView_name_verse;
    private TextView TextView_versenum;

    private int chapter;
    private String bible;
    private int chapterNum;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verse_main);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        fragmentManager = getSupportFragmentManager();
        fragment = new Verse_Fragment();
        fragmentChange = new Verse_Fragment();

        fragment.setArguments(bundle);

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame, fragment).commitAllowingStateLoss();

        TextView_name_verse = findViewById(R.id.name_verse);
        bible = bundle.getString("chapter").substring(3);
        chapter = bundle.getInt("verse") + 1;
        path = bundle.getString("path");
        TextView_name_verse.setText(bible + " " + Integer.toString(chapter) + "장");

        TextView_versenum = findViewById(R.id.textview_versenum);
        chapterNum = bundle.getInt("numVerse");
        TextView_versenum.setText(Integer.toString(chapter) + "/" + Integer.toString(chapterNum));

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

    }

    public void clickhandler(View View){
        transaction = fragmentManager.beginTransaction();

        switch (View.getId()){
            case R.id.imageview_prev:
                if(chapter>1){
                    chapter--;
                    TextView_name_verse.setText(bible + " " + Integer.toString(chapter) + "장");
                    TextView_versenum.setText(Integer.toString(chapter) + "/" + Integer.toString(chapterNum));
                    Bundle b = new Bundle();
                    b.putString("path", path);
                    b.putInt("verse", chapter-1);
                    fragmentChange.setArguments(b);
                    transaction.replace(R.id.frame, fragmentChange).commitAllowingStateLoss();
                    temp = fragment;
                    fragment = fragmentChange;
                    fragmentChange = temp;
                }
                break;
            case R.id.imageview_next:
                if(chapter<chapterNum){
                    chapter++;
                    TextView_name_verse.setText(bible + " " + Integer.toString(chapter) + "장");
                    TextView_versenum.setText(Integer.toString(chapter) + "/" + Integer.toString(chapterNum));
                    Bundle b = new Bundle();
                    b.putString("path", path);
                    b.putInt("verse", chapter-1);
                    fragmentChange.setArguments(b);
                    transaction.replace(R.id.frame, fragmentChange).commitAllowingStateLoss();
                    temp = fragment;
                    fragment = fragmentChange;
                    fragmentChange = temp;
                }
                break;
        }
    }
}