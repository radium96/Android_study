package com.naca.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.naca.myapplication.databinding.BossRowBinding;

import java.util.ArrayList;
import java.util.List;

public class BossListAdapter extends RecyclerView.Adapter<BossListAdapter.BindingViewHolder> {

    private List<Boss> bossList;

    public BossListAdapter(){
        this.bossList = new ArrayList<>();
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BossRowBinding binding = BossRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder holder, int position) {
        Boss boss = bossList.get(position);
        holder.bind(boss);
    }

    @Override
    public int getItemCount() {
        return bossList.size();
    }

    public void setTItem(List<Boss> boss) {
        this.bossList = boss;
        notifyDataSetChanged();
    }

    public class BindingViewHolder extends RecyclerView.ViewHolder {

        BossRowBinding binding;

        public BindingViewHolder(@NonNull BossRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Boss boss) {
            binding.setVariable(BR.boss, boss);
        }
    }

}
