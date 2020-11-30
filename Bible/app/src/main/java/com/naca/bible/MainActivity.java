package com.naca.bible;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView Bible_recycler_view;
    private BibleAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] chapterset = {"창세기", "출애굽기", "레위기", "민수기", "신명기", "여호수아", "사사기", "룻기", "사무엘상", "사무엘하", "열왕기상", "열왕기하"
                                    , "역대상", "역대하", "에스라", "느헤미야", "에스더", "욥기", "시편", "잠언", "전도서", "아가", "이사야", "예레미야", "예레미야 애가"
                                    , "에스겔", "다니엘", "호세아", "요엘", "아모스", "오바댜", "요나", "미가", "나훔", "하박국", "스바냐", "학개", "스가랴", "말라기"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_old);

        Bible_recycler_view = findViewById(R.id.bible_recycler_view);
        Bible_recycler_view.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        Bible_recycler_view.setLayoutManager(layoutManager);

        mAdapter = new BibleAdapter(chapterset);
        mAdapter.setOnItemClickListener(new BibleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Log.d("CLICK", Integer.toString(position));

                Intent intent = new Intent(MainActivity.this, ChapterActivity_01.class);;
                intent.putExtra("chapter", position);
                intent.putExtra("chapterName", chapterset[position]);

                startActivity(intent);
            }
        });
        Bible_recycler_view.setAdapter(mAdapter);
    }
}