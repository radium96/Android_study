package com.naca.newbible.ui.view;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.naca.newbible.R;
import com.naca.newbible.databinding.ChapterMainBinding;
import com.naca.newbible.ui.adapter.ChapterGridAdapter;

import java.io.IOException;
import java.io.InputStream;

public class ChapterMain extends AppCompatActivity {

    private ChapterMainBinding binding;
    private RecyclerView.LayoutManager layoutManager;
    private ChapterGridAdapter mAdapter;

    private int[] chapter;
    private int pos;
    private String on;
    private String chapterName;
    private String[] chapters;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.chapter_main);
        binding.setLifecycleOwner(this);

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

        binding.chapterRecyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 5);
        binding.chapterRecyclerView.setLayoutManager(layoutManager);

        binding.bibleName.setText(chapterName);
        mAdapter = new ChapterGridAdapter(chapter);
        binding.chapterRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new ChapterGridAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(ChapterMain.this, VerseMain.class);
                intent.putExtra("path", path);
                intent.putExtra("verse", position);
                intent.putExtra("chapter", chapters[pos]);
                intent.putExtra("numVerse", chapter.length);
                startActivity(intent);
            }
        });
    }
}