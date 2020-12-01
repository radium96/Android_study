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

public class Bible_Fragment_new extends Fragment {

    private RecyclerView Bible_recycler_view;
    private BibleAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] chapterset = {"마태복음", "마가복음", "누가복음", "요한복음", "사도행전", "로마서", "고린도전서", "고린도후서", "갈라디아서", "에베소서", "빌립보서", "골로새서",
            "데살로니가전서", "데살로니가후서", "디모데전서", "디모데후서", "디도서", "빌레몬서", "히브리서", "야고보서", "베드로전서", "베드로후서", "요한1서",
            "요한2서", "요한3서", "유다서", "요한계시록"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_new, container, false);
        Bible_recycler_view = (RecyclerView) view.findViewById(R.id.bible_recycler_view);
        Bible_recycler_view.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        Bible_recycler_view.setLayoutManager(layoutManager);
        Bible_recycler_view.scrollToPosition(0);

        mAdapter = new BibleAdapter(chapterset);
        mAdapter.setOnItemClickListener(new BibleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Log.d("CLICK", Integer.toString(position));

                Intent intent = new Intent(getContext(), ChapterActivity_02.class);;
                intent.putExtra("chapter", position);
                intent.putExtra("chapterName", chapterset[position]);

                startActivity(intent);
            }
        });
        Bible_recycler_view.setAdapter(mAdapter);

        return view;
    }

}
