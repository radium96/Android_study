package com.naca.maplecrystalcalculator.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.naca.maplecrystalcalculator.R;
import com.naca.maplecrystalcalculator.data.Boss;
import com.naca.maplecrystalcalculator.databinding.BossRecyclerBinding;
import com.naca.maplecrystalcalculator.ui.adapter.BossListAdapter;
import com.naca.maplecrystalcalculator.ui.viewModel.BossListViewModel;

public class BossList_Fragment extends Fragment {

    private ObservableArrayList<Boss> boss;
    private BossRecyclerBinding binding;
    private BossListAdapter mAdapter;
    private RecyclerView BossListView;

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.boss_recyclerview, container, false);
        View root = binding.getRoot();

        mAdapter = new BossListAdapter();
        boss = new ObservableArrayList<>();

        binding.bosslistrecyclerview.setAdapter(mAdapter);
        binding.setBossList(boss);

        return root;
    }
}