package com.naca.bible;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Bible_Fragment_old extends Fragment {

    private RecyclerView Bible_recycler_view;
    private BibleAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] chapterset = {"창세기", "출애굽기", "레위기", "민수기", "신명기", "여호수아", "사사기", "룻기", "사무엘상", "사무엘하", "열왕기상", "열왕기하"
            , "역대상", "역대하", "에스라", "느헤미야", "에스더", "욥기", "시편", "잠언", "전도서", "아가", "이사야", "예레미야", "예레미야 애가"
            , "에스겔", "다니엘", "호세아", "요엘", "아모스", "오바댜", "요나", "미가", "나훔", "하박국", "스바냐", "학개", "스가랴", "말라기"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.news_old, container, false);
        Bible_recycler_view = (RecyclerView) view.findViewById(R.id.bible_recycler_view);
        Bible_recycler_view.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        Bible_recycler_view.setLayoutManager(layoutManager);
        Bible_recycler_view.scrollToPosition(0);

        mAdapter = new BibleAdapter(chapterset);
        Bible_recycler_view.setAdapter(mAdapter);

        return view;
    }

}
