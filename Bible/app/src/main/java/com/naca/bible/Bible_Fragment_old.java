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
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.naca.bible.databinding.NewsOldBinding;
import com.naca.bible.ui.adapter.BibleListViewAdapter;
import com.naca.bible.ui.viewModel.BibleListViewModel;

import java.io.IOException;
import java.io.InputStream;

public class Bible_Fragment_old extends Fragment {

    private RecyclerView Bible_recycler_view;
    private BibleListViewAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] chapterset;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        NewsOldBinding oldBinding = DataBindingUtil.inflate(inflater, R.layout.news_old, container, false);
        oldBinding.setViewmodel(new BibleListViewModel());

        View view = oldBinding.getRoot();

        AssetManager am = getResources().getAssets();
        InputStream is = null;

        try {
            chapterset = am.list("old");
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

        mAdapter = new BibleListViewAdapter(chapterset);
//        mAdapter.setOnItemClickListener(new BibleAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View v, int position) {
//                Intent intent = new Intent(getContext(), ChapterActivity.class);
//                intent.putExtra("on", "old");
//                intent.putExtra("chapter", position);
//                intent.putExtra("chapterName", chapterset[position]);
//                startActivity(intent);
//            }
//        });
        Bible_recycler_view.setAdapter(mAdapter);

        return view;
    }

}
