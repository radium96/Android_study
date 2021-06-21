package com.naca.newbible.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.naca.newbible.databinding.RowBibleBinding;

import java.util.LinkedList;

public class VerseListAdapter extends RecyclerView.Adapter<VerseListAdapter.BindingViewHolder> {

    private LinkedList<String> verseSet;

    public VerseListAdapter(LinkedList<String> verseSet) {
        this.verseSet = verseSet;
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowBibleBinding binding = RowBibleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder holder, int position) {
        holder.bind(verseSet.get(position));
    }

    @Override
    public int getItemCount() {
        return verseSet.size();
    }

    public class BindingViewHolder extends RecyclerView.ViewHolder{

        RowBibleBinding binding;

        public BindingViewHolder(@NonNull RowBibleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String bible) {
            binding.setVariable(BR.bible, bible);
        }
    }

}
