package com.naca.maplecrystalcalcualtor.ui.viewModel;

import android.app.AlertDialog;

import androidx.lifecycle.ViewModel;

import com.naca.maplecrystalcalcualtor.data.TSLiveData;

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
