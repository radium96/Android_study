package com.naca.bible.data;

import androidx.lifecycle.MutableLiveData;

public class BibleLiveData<T> extends MutableLiveData<T> {

    public BibleLiveData(){

    }

    public BibleLiveData(T value){
        setValue(value);
    }
}
