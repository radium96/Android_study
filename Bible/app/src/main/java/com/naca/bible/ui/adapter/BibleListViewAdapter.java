package com.naca.bible.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.naca.bible.R;
import com.naca.bible.databinding.RowBibleBinding;
import com.naca.bible.ui.viewHolder.BibleListViewHolder;
import com.naca.bible.ui.viewModel.BibleListItemViewModel;

import java.util.ArrayList;

public class BibleListViewAdapter extends RecyclerView.Adapter<BibleListViewHolder<RowBibleBinding>> {
    private ArrayList<BibleListItemViewModel> listItemViewModels = new ArrayList<>();

    public BibleListViewAdapter(String[] cs) {
        for(int i = 0;i<cs.length;i++)
            listItemViewModels.add(new BibleListItemViewModel(cs[i]));
    }

    @NonNull
    @Override
    public BibleListViewHolder<RowBibleBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new BibleListViewHolder<>(inflater.inflate(R.layout.row_bible, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BibleListViewHolder<RowBibleBinding> holder, int position) {
        holder.getBinding().setViewmodel(listItemViewModels.get(position));
    }

    @Override
    public int getItemCount() {
        return listItemViewModels.size();
    }
}
