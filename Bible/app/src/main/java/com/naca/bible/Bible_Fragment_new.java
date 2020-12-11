package com.naca.bible;

import android.content.Intent;
import android.content.res.AssetManager;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Bible_Fragment_new extends Fragment {

    private RecyclerView Bible_recycler_view;
    private BibleAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] chapterset;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_new, container, false);

        AssetManager am = getResources().getAssets();

        try {
            chapterset = am.list("new");

        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0;i<chapterset.length;i++){
            chapterset[i] = chapterset[i].substring(3);
        }


        Bible_recycler_view = (RecyclerView) view.findViewById(R.id.bible_recycler_view);
        Bible_recycler_view.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        Bible_recycler_view.setLayoutManager(layoutManager);
        Bible_recycler_view.scrollToPosition(0);

        mAdapter = new BibleAdapter(chapterset);
        mAdapter.setOnItemClickListener(new BibleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getContext(), ChapterActivity.class);
                intent.putExtra("on", "new");
                intent.putExtra("chapter", position);
                intent.putExtra("chapterName", chapterset[position]);
                startActivity(intent);
            }
        });
        Bible_recycler_view.setAdapter(mAdapter);

        return view;
    }

}
