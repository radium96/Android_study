package com.naca.newbible.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.naca.newbible.databinding.RowBibleBinding;

public class BibleListAdapter extends RecyclerView.Adapter<BibleListAdapter.BindingViewHolder> {

    private String[] chapterSet;

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public static OnItemClickListener mListener = null;

    public BibleListAdapter(String[] chapterSet) {
        this.chapterSet = chapterSet;
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowBibleBinding binding = RowBibleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder holder, int position) {
        holder.bind(chapterSet[position]);
    }

    @Override
    public int getItemCount() {
        return chapterSet.length;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }

    public class BindingViewHolder extends RecyclerView.ViewHolder{

        RowBibleBinding binding;

        public BindingViewHolder(@NonNull RowBibleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getBindingAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        if (BibleListAdapter.mListener != null){
                            BibleListAdapter.mListener.onItemClick(v, position);
                        }
                    }
                }
            });
        }

        public void bind(String bible) {
            binding.setVariable(BR.bible, bible);
        }
    }

}
