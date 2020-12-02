package com.naca.bible;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

class VerseAdapter extends RecyclerView.Adapter<VerseAdapter.MyViewHolder> {
    private LinkedList<String> mDataset;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textview_verse = itemView.findViewById(R.id.textview_verse);

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public VerseAdapter(LinkedList<String> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    // RecyclerView에 들어가는 리스트 항목을 불러옴
    @Override
    public VerseAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_verse, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textview_verse.setText(mDataset.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
