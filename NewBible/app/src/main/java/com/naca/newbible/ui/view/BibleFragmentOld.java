package com.naca.newbible.ui.view;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.naca.bible.databinding.NewsOldBinding;
import com.naca.bible.ui.adapter.BibleListViewAdapter;
import com.naca.bible.ui.viewModel.BibleListViewModel;
import com.naca.newbible.R;
import com.naca.newbible.databinding.FragmentOldBinding;
import com.naca.newbible.ui.viewModel.BibleFragmentOldViewModel;

import java.io.IOException;
import java.io.InputStream;

public class BibleFragmentOld extends Fragment {

    private RecyclerView bible_frag_new;
    private BibleFragmentOldViewModel viewModel;
    private RecyclerView.LayoutManager layoutManager;
    private String[] chapterset;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentOldBinding binding = DataBindingUtil.inflate(inflater, R.layout.bible_fragment_old, container, false);
        binding.setLifecycleOwner(this);

        viewModel = new ViewModelProvider(this).get(BibleFragmentOldViewModel.class);

        View view = binding.getRoot();

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

    @BindingAdapter("chapterList")
    public static void setItems(RecyclerView recyclerView, String[] chapterset){
        BibleListViewAdapter adapter = (BibleListViewAdapter) recyclerView.getAdapter();

    }



}
