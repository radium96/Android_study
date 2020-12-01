package com.naca.bible;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ChapterActivity_02 extends AppCompatActivity {

    private RecyclerView chapter_recycler_view;
    private ChapterAdapter mAdapter;
    private TextView TextView_chapter_name;
    private RecyclerView.LayoutManager layoutManager;
    private int[] chapter;
    private int position;
    private String chapterName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_chapter);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        position = bundle.getInt("chapter");
        chapterName = bundle.getString("chapterName");
        if(position == 0) {chapter = new int[28];}
        else if(position == 1) {chapter = new int[16];}
        else if(position == 2) {chapter = new int[24];}
        else if(position == 3) {chapter = new int[21];}
        else if(position == 4) {chapter = new int[28];}
        else if(position == 5) {chapter = new int[16];}
        else if(position == 6) {chapter = new int[16];}
        else if(position == 7) {chapter = new int[13];}
        else if(position == 8) {chapter = new int[6];}
        else if(position == 9) {chapter = new int[6];}
        else if(position == 10) {chapter = new int[4];}
        else if(position == 11) {chapter = new int[4];}
        else if(position == 12) {chapter = new int[5];}
        else if(position == 13) {chapter = new int[3];}
        else if(position == 14) {chapter = new int[6];}
        else if(position == 15) {chapter = new int[4];}
        else if(position == 16) {chapter = new int[3];}
        else if(position == 17) {chapter = new int[1];}
        else if(position == 18) {chapter = new int[13];}
        else if(position == 19) {chapter = new int[5];}
        else if(position == 20) {chapter = new int[5];}
        else if(position == 21) {chapter = new int[3];}
        else if(position == 22) {chapter = new int[5];}
        else if(position == 23) {chapter = new int[1];}
        else if(position == 24) {chapter = new int[1];}
        else if(position == 25) {chapter = new int[1];}
        else if(position == 26) {chapter = new int[22];}

        for(int i = 0;i<chapter.length;i++){
            chapter[i] = i+1;
        }

        TextView_chapter_name = findViewById(R.id.name_chapter);
        TextView_chapter_name.setText(chapterName);

        chapter_recycler_view = findViewById(R.id.chapter_recycler_view);
        chapter_recycler_view.setHasFixedSize(true);

        int numOfColumns = 5;
        layoutManager = new GridLayoutManager(this, numOfColumns);
        chapter_recycler_view.setLayoutManager(layoutManager);

        mAdapter = new ChapterAdapter(chapter);
        chapter_recycler_view.setAdapter(mAdapter);


    }
}