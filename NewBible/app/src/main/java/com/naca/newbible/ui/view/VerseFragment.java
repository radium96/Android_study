package com.naca.newbible.ui.view;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.naca.newbible.R;
import com.naca.newbible.databinding.FragmentVerseBinding;
import com.naca.newbible.ui.adapter.VerseListAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class VerseFragment extends Fragment {

    private RecyclerView Verse_recycler_view;
    private VerseListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private String[] versearr;
    private String path;
    private int chapter;
    private LinkedList<String> verse = new LinkedList<>();
    private String tmp = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        FragmentVerseBinding binding = DataBindingUtil.inflate(inflater, R.layout.verse_fragment, container, false);
        binding.setLifecycleOwner(this);
        View view = binding.getRoot();

        Bundle bundle = getArguments();
        path = bundle.getString("path");
        chapter = bundle.getInt("verse");

        AssetManager am = getResources().getAssets();
        InputStream is = null;

        BufferedReader br;

        verse.clear();

        try {
            versearr = am.list(path);
            path = path + "/" + versearr[chapter];
            is = am.open(path);
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            while ((tmp = br.readLine()) != null){
                verse.add(tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        binding.verseRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        binding.verseRecyclerView.setLayoutManager(layoutManager);
        binding.verseRecyclerView.scrollToPosition(0);

        mAdapter = new VerseListAdapter(verse);
        binding.verseRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
