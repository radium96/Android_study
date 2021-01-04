package com.example.maplecrystalcalcualtor.ui.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.maplecrystalcalcualtor.data.TSLiveData;

public class BossListViewModel extends ViewModel {

    public TSLiveData<Integer> peopleNum = new TSLiveData<>();
    public TSLiveData<String> difficulty = new TSLiveData<>();
    public TSLiveData<Integer> count = new TSLiveData<>();

    public void setPeopleNum(int peopleNum) {

    }

    public void setDifficulty(String difficulty) {

    }

    public void setCount(int count) {

    }

    public void setCountArray(int position){

    }

    public void setDiffArray(int position){

    }
}
