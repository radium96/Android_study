package com.naca.calender.data;

import androidx.lifecycle.MutableLiveData;

public class NLiveData<T> extends MutableLiveData<T> {

    public NLiveData(){
    }

    public NLiveData(T value){
        setValue(value);
    }
}
