package com.naca.bible;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.MyViewHolder> {
    private int[] mDataset;

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public static OnItemClickListener mListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) { this.mListener = listener; }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_chapter = itemView.findViewById(R.id.textView_chapter);

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        if (ChapterAdapter.mListener != null){
                            ChapterAdapter.mListener.onItemClick(v, position);
                        }
                    }
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ChapterAdapter(int[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    // RecyclerView에 들어가는 리스트 항목을 불러옴
    @Override
    public ChapterAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element_chapter, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView_chapter.setText(Integer.toString(mDataset[position]));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
