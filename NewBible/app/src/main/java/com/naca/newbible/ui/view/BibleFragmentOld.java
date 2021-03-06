package com.naca.newbible.ui.view;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.naca.newbible.R;
import com.naca.newbible.databinding.FragmentOldBinding;
import com.naca.newbible.ui.adapter.BibleListAdapter;
import com.naca.newbible.ui.viewModel.BibleFragmentOldViewModel;

import java.io.IOException;
import java.io.InputStream;

public class BibleFragmentOld extends Fragment {

    private BibleFragmentOldViewModel viewModel;
    private RecyclerView.LayoutManager layoutManager;
    private BibleListAdapter mAdapter;
    private String[] chapterSet;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        FragmentOldBinding binding = DataBindingUtil.inflate(inflater, R.layout.bible_fragment_old, container, false);
        binding.setLifecycleOwner(this);
        viewModel = new ViewModelProvider(this).get(BibleFragmentOldViewModel.class);

        View view = binding.getRoot();

        AssetManager am = getResources().getAssets();
        InputStream is = null;

        try {
            chapterSet = am.list("old");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0;i<chapterSet.length;i++){
            chapterSet[i] = chapterSet[i].substring(3);
        }

        binding.bibleRecyclerOld.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        binding.bibleRecyclerOld.setLayoutManager(layoutManager);

        mAdapter = new BibleListAdapter(chapterSet);
        mAdapter.setOnItemClickListener(new BibleListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getContext(), ChapterMain.class);
                intent.putExtra("on", "old");
                intent.putExtra("chapter", position);
                intent.putExtra("chapterName", chapterSet[position]);
                startActivity(intent);
            }
        });
        binding.bibleRecyclerOld.setAdapter(mAdapter);

        return view;
    }
}
