package com.naca.maplecrystalcalculator.ui.viewModel;

import androidx.lifecycle.ViewModel;

import com.naca.maplecrystalcalculator.data.TSLiveData;

public class BossFragmentViewModel extends ViewModel {

    TSLiveData<String> charName = new TSLiveData<>();
    TSLiveData<String> className = new TSLiveData<>();
    TSLiveData<Integer> level = new TSLiveData<>();

    public void setCharName(String charName) {
        this.charName.setValue(charName);
    }

    public void setClassName(String className) {
        this.className.setValue(className);
    }

    public void setLevel(int level) {
        this.level.setValue(level);
    }
}
