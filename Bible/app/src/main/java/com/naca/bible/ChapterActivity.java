package com.naca.bible;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;

public class ChapterActivity extends AppCompatActivity {

    private RecyclerView chapter_recycler_view;
    private ChapterAdapter mAdapter;
    private TextView TextView_chapter_name;
    private RecyclerView.LayoutManager layoutManager;

    private int[] chapter;
    private int pos;
    private String on;
    private String chapterName;
    private String[] chapters;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_chapter);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        on = bundle.getString("on");
        pos = bundle.getInt("chapter");
        chapterName = bundle.getString("chapterName");

        AssetManager am = getResources().getAssets();
        InputStream is = null;

        if(on.equals("old")){
            try {
                chapters = am.list("old");
                path = "old/" + chapters[pos];
                chapter = new int[am.list(path).length];
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                chapters = am.list("new");
                path = "new/" + chapters[pos];
                chapter = new int[am.list(path).length];
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

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
        mAdapter.setOnItemClickListener(new ChapterAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(ChapterActivity.this, Verse_Main.class);
                intent.putExtra("path", path);
                intent.putExtra("verse", position);
                intent.putExtra("chapter", chapters[pos]);
                intent.putExtra("numVerse", chapter.length);
                startActivity(intent);
            }
        });
        chapter_recycler_view.setAdapter(mAdapter);


    }
}