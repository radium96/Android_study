package com.naca.newbible.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.naca.newbible.databinding.ElementChapterBinding;

public class ChapterGridAdapter extends RecyclerView.Adapter<ChapterGridAdapter.BindingViewHolder> {

    private int[] chapterSet;

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public static OnItemClickListener mListener = null;

    public ChapterGridAdapter(int[] chapterSet) {
        this.chapterSet = chapterSet;
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ElementChapterBinding binding = ElementChapterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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

        ElementChapterBinding binding;

        public BindingViewHolder(@NonNull ElementChapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getBindingAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        if (ChapterGridAdapter.mListener != null){
                            ChapterGridAdapter.mListener.onItemClick(v, position);
                        }
                    }
                }
            });
        }

        public void bind(int chapter) {
            binding.setVariable(BR.chapter, Integer.toString(chapter));
        }
    }
}
