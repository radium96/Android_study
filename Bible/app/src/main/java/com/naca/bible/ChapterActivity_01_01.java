package com.naca.bible;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ChapterActivity_01_01 extends AppCompatActivity {

    private RecyclerView chapter_recycler_view;
    private ChapterAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private int[] chapter = new int[50];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_chapter);

        for(int i = 0;i<chapter.length;i++){
            chapter[i] = i+1;
        }

        chapter_recycler_view = findViewById(R.id.chapter_recycler_view);
        chapter_recycler_view.setHasFixedSize(true);

        int numOfColumns = 5;
        layoutManager = new GridLayoutManager(this, numOfColumns);
        chapter_recycler_view.setLayoutManager(layoutManager);

        mAdapter = new ChapterAdapter(chapter);
        chapter_recycler_view.setAdapter(mAdapter);


    }
}