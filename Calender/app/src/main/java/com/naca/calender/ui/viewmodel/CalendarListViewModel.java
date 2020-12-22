package com.naca.calender.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.naca.calender.data.TSLiveData;
import com.naca.calender.util.DateFormat;
import com.naca.calender.util.Keys;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarListViewModel extends ViewModel {
    private long mCurrentTime;

    public TSLiveData<String> mTitle = new TSLiveData<>();
    public TSLiveData<ArrayList<Object>> mCalenderList = new TSLiveData<>(new ArrayList<>());

    public int mCenterPosition;

    public void setTitle(int position){
        try {
            Object item = mCalenderList.getValue().get(position);
            if(item instanceof Long){
                setTitle((Long) item);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setTitle(long time){
        mCurrentTime = time;
        mTitle.setValue(DateFormat.getDate(time, DateFormat.CALENDAR_HEADER_FORMAT));
    }

    public void initCalendarList() {
        GregorianCalendar cal = new GregorianCalendar();
        setCalenderlist(cal);
    }

    public void setCalenderlist(GregorianCalendar cal) {

        setTitle(cal.getTimeInMillis());

        ArrayList<Object> calendarList = new ArrayList<>();
        for(int i = -300; i<300;i++){
            try{
                GregorianCalendar calendar = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+i, 1, 0, 0, 0);
                if(i == 0){
                    mCenterPosition = calendarList.size();
                }
                calendarList.add(calendar.getTimeInMillis());

                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) -1;
                int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                for (int j = 0; j<dayOfWeek; j++){
                    calendarList.add(Keys.EMPTY);
                }
                for (int j = 1; j <= max; j++) {
                    calendarList.add(new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), j));
                }

            } catch (Exception e){
                e.printStackTrace();
            }
        }
        mCalenderList.setValue(calendarList);


    }
}
