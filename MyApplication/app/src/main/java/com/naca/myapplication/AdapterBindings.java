package com.naca.myapplication;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterBindings {

    @BindingAdapter({"item"})
    public static void bindItem(RecyclerView recyclerView, ObservableArrayList<Boss> boss) {
        BossListAdapter adapter = (BossListAdapter)recyclerView.getAdapter();
        if(adapter != null){
            adapter.setItem(boss);
        }
    }

    @BindingAdapter({"image"})
    public static void loadImg(ImageView imageView, int imageId) {
        imageView.setImageResource(imageId);
    }
}
