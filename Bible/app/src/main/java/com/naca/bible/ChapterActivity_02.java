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
//        chapterName = bundle.getString("chapterName");
        if(position == 0) {chapter = new int[28]; chapterName="마태복음";}
        else if(position == 1) {chapter = new int[16]; chapterName="마가복음";}
        else if(position == 2) {chapter = new int[24]; chapterName="누가복음";}
        else if(position == 3) {chapter = new int[21]; chapterName="요한복음";}
        else if(position == 4) {chapter = new int[28]; chapterName="사도행전";}
        else if(position == 5) {chapter = new int[16]; chapterName="로마서";}
        else if(position == 6) {chapter = new int[16]; chapterName="고린도전서";}
        else if(position == 7) {chapter = new int[13]; chapterName="고린도후서";}
        else if(position == 8) {chapter = new int[6]; chapterName="갈라디아서";}
        else if(position == 9) {chapter = new int[6]; chapterName="에베소서";}
        else if(position == 10) {chapter = new int[4]; chapterName="빌립보서";}
        else if(position == 11) {chapter = new int[4]; chapterName="골로새서";}
        else if(position == 12) {chapter = new int[5]; chapterName="데살로니가전서";}
        else if(position == 13) {chapter = new int[3]; chapterName="데살로니가후서";}
        else if(position == 14) {chapter = new int[6]; chapterName="디모데전서";}
        else if(position == 15) {chapter = new int[4]; chapterName="디모데후서";}
        else if(position == 16) {chapter = new int[3]; chapterName="디도서";}
        else if(position == 17) {chapter = new int[1]; chapterName="빌레몬서";}
        else if(position == 18) {chapter = new int[13]; chapterName="히브리서";}
        else if(position == 19) {chapter = new int[5]; chapterName="야고보서";}
        else if(position == 20) {chapter = new int[5]; chapterName="베드로전서";}
        else if(position == 21) {chapter = new int[3]; chapterName="베드로후서";}
        else if(position == 22) {chapter = new int[5]; chapterName="요한1서";}
        else if(position == 23) {chapter = new int[1]; chapterName="요한2서";}
        else if(position == 24) {chapter = new int[1]; chapterName="요한3서";}
        else if(position == 25) {chapter = new int[1]; chapterName="유다서";}
        else if(position == 26) {chapter = new int[22]; chapterName="요한계시록";}

        for(int i = 0;i<chapter.length;i++){
            chapter[i] = i+1;
        }

        TextView_chapter_name.findViewById(R.id.name_chapter);
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