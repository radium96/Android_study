package com.naca.myapplication;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterBindings {

    @BindingAdapter({"item"})
    public static void bindItem(RecyclerView recyclerView, ObservableArrayList<Boss> boss) {
        BossListAdapter adapter = (BossListAdapter)recyclerView.getAdapter();
        if(adapter != null){
            adapter.setTItem(boss);
        }
    }
}
