package com.naca.bible;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Verse_Fragment extends Fragment {

    private RecyclerView Verse_recycler_view;
    private VerseAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private String[] versearr;
    private String path;
    private int chapter;
    private LinkedList<String> verse = new LinkedList<>();
    private String tmp = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.verse_recy, container, false);

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


        Verse_recycler_view = (RecyclerView) view.findViewById(R.id.verse_recycler_view);
        Verse_recycler_view.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        Verse_recycler_view.setLayoutManager(layoutManager);
        Verse_recycler_view.scrollToPosition(0);

        mAdapter = new VerseAdapter(verse);
        Verse_recycler_view.setAdapter(mAdapter);

        return view;
    }
}
