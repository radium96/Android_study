package com.naca.calender.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.naca.calender.data.TSLiveData;

public class CalenderHeaderViewModel extends ViewModel {
    public TSLiveData<Long> mHeaderData = new TSLiveData<>();

    public void setHeaderData(long headerData) {
        this.mHeaderData.setValue(headerData);
    }

}
