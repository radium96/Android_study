package com.naca.maplecrystalcalculator.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.naca.maplecrystalcalculator.R;
import com.naca.maplecrystalcalculator.databinding.BossRowBinding;
import com.naca.maplecrystalcalculator.ui.viewModel.BossListViewModel;

public class BossListAdapter extends RecyclerView.Adapter<BossListAdapter.BossRowHolder> {

    public class BossRowHolder extends RecyclerView.ViewHolder {
        private BossRowBinding binding;

        public BossRowHolder(@NonNull BossRowBinding binding) {
            super(binding.getRoot());



            this.binding = binding;
        }

        private void setViewModel(BossListViewModel model){
            binding.setModel(model);
            binding.executePendingBindings();
        }
    }

    @NonNull
    @Override
    public BossListAdapter.BossRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BossRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_boss, parent, false);

        return new BossRowHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BossRowHolder holder, int position) {
        BossListViewModel model = new BossListViewModel();
        holder.setViewModel(model);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
