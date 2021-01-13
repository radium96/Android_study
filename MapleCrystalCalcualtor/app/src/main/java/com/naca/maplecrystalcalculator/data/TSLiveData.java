package com.naca.maplecrystalcalculator.data;

import androidx.lifecycle.MutableLiveData;

public class TSLiveData<T> extends MutableLiveData {
    public TSLiveData(){

    }

    public TSLiveData(T value) {
        setValue(value);
    }
}
