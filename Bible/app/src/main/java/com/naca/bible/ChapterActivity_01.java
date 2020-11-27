package com.naca.bible;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ChapterActivity_01 extends AppCompatActivity {

    private RecyclerView chapter_recycler_view;
    private ChapterAdapter mAdapter;
    private TextView TextView_chapter_name;
    private RecyclerView.LayoutManager layoutManager;
    private int[] chapter;
    private int position;
    private String chapterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_chapter);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        position = bundle.getInt("chapter");
//        chapterName = bundle.getString("chapterName");
        if(position == 0) {chapter = new int[50]; chapterName="창세기";}
        else if(position == 1) {chapter = new int[40]; chapterName="출애굽기";}
        else if(position == 2) {chapter = new int[27]; chapterName="레위기";}
        else if(position == 3) {chapter = new int[36]; chapterName="민수기";}
        else if(position == 4) {chapter = new int[34]; chapterName="신명기";}
        else if(position == 5) {chapter = new int[24]; chapterName="여호수아";}
        else if(position == 6) {chapter = new int[21]; chapterName="사사기";}
        else if(position == 7) {chapter = new int[4]; chapterName="룻기";}
        else if(position == 8) {chapter = new int[31]; chapterName="사무엘상";}
        else if(position == 9) {chapter = new int[24]; chapterName="사무엘하";}
        else if(position == 10) {chapter = new int[22]; chapterName="열왕기상";}
        else if(position == 11) {chapter = new int[25]; chapterName="열왕기하";}
        else if(position == 12) {chapter = new int[29]; chapterName="역대상";}
        else if(position == 13) {chapter = new int[36]; chapterName="역대하";}
        else if(position == 14) {chapter = new int[10]; chapterName="에스라";}
        else if(position == 15) {chapter = new int[13]; chapterName="느헤미야";}
        else if(position == 16) {chapter = new int[10]; chapterName="에스더";}
        else if(position == 17) {chapter = new int[42]; chapterName="욥기";}
        else if(position == 18) {chapter = new int[150]; chapterName="시편";}
        else if(position == 19) {chapter = new int[31]; chapterName="잠언";}
        else if(position == 20) {chapter = new int[12]; chapterName="전도서";}
        else if(position == 21) {chapter = new int[8]; chapterName="아가";}
        else if(position == 22) {chapter = new int[66]; chapterName="이사야";}
        else if(position == 23) {chapter = new int[52]; chapterName="예레미야";}
        else if(position == 24) {chapter = new int[5]; chapterName="예레미야 애가";}
        else if(position == 25) {chapter = new int[48]; chapterName="에스겔";}
        else if(position == 26) {chapter = new int[12]; chapterName="다니엘";}
        else if(position == 27) {chapter = new int[14]; chapterName="호세아";}
        else if(position == 28) {chapter = new int[3]; chapterName="요엘";}
        else if(position == 29) {chapter = new int[9]; chapterName="아모스";}
        else if(position == 30) {chapter = new int[1]; chapterName="오바댜";}
        else if(position == 31) {chapter = new int[4]; chapterName="요나";}
        else if(position == 32) {chapter = new int[7]; chapterName="미가";}
        else if(position == 33) {chapter = new int[3]; chapterName="나훔";}
        else if(position == 34) {chapter = new int[3]; chapterName="하박국";}
        else if(position == 35) {chapter = new int[3]; chapterName="스바냐";}
        else if(position == 36) {chapter = new int[2]; chapterName="힉게";}
        else if(position == 37) {chapter = new int[14]; chapterName="스가랴";}
        else if(position == 38) {chapter = new int[4]; chapterName="말라기";}


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