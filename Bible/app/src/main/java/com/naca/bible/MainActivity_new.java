package com.naca.bible;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity_new extends AppCompatActivity {
    private TextView TextView_newsnew;
    private TextView TextView_newsold;
    private RecyclerView bible_recycler_view;
    private BibleAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] chapterset = {"마태복음", "마가복음", "누가복음", "요한복음", "사도행전", "로마서", "고린도전서", "고린도후서", "갈라디아서", "에베소서", "빌립보서", "골로새서",
                                   "데살로니가전서", "데살로니가후서", "디모데전서", "디모데후서", "디도서", "빌레몬서", "히브리서", "야고보서", "베드로전서", "베드로후서", "요한1서",
                                   "요한2서", "요한3서", "유다서", "요한계시록"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_new);

        bible_recycler_view = findViewById(R.id.bible_recycler_view);
        bible_recycler_view.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        bible_recycler_view.setLayoutManager(layoutManager);

        mAdapter = new BibleAdapter(chapterset);
        mAdapter.setOnItemClickListener(new BibleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Log.d("CLICK", Integer.toString(position));

                Intent intent = new Intent(MainActivity_new.this, ChapterActivity_02.class);;
                intent.putExtra("chapter", position);
                intent.putExtra("chapterName", chapterset[position]);

                startActivity(intent);
            }
        });
        bible_recycler_view.setAdapter(mAdapter);

//        TextView_newsnew = findViewById(R.id.newnews);
//        TextView_newsold = findViewById(R.id.oldnews);
        TextView_newsold.setClickable(true);
        TextView_newsold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_new.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}