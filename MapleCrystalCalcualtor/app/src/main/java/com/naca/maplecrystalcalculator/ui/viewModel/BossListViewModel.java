package com.naca.maplecrystalcalculator.ui.viewModel;

import androidx.lifecycle.ViewModel;

import com.naca.maplecrystalcalculator.data.TSLiveData;

public class BossListViewModel extends ViewModel {

    public TSLiveData<Integer> peopleNum = new TSLiveData<>();
    public TSLiveData<String> difficulty = new TSLiveData<>();
    public TSLiveData<Integer> count = new TSLiveData<>();

}
