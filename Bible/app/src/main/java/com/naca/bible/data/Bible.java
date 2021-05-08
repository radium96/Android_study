package com.naca.bible.data;

import androidx.lifecycle.MutableLiveData;

public class Bible {
    private MutableLiveData<String> bibleName = new MutableLiveData<>();

    public Bible(){
    }

    public Bible(String bibleName){
        this.bibleName.setValue(bibleName);
    }

    public MutableLiveData<String> getBibleName() {
        return bibleName;
    }

    public void setBibleName(MutableLiveData<String> bibleName) {
        this.bibleName = bibleName;
    }
}


