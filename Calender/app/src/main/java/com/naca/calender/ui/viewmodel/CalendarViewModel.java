package com.naca.calender.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.naca.calender.data.TSLiveData;

import java.util.Calendar;

public class CalendarViewModel extends ViewModel {
    public TSLiveData<Calendar> mCalendar = new TSLiveData<>();

    public void setCalendar(Calendar calendar) {
        this.mCalendar.setValue(calendar);
    }
}
