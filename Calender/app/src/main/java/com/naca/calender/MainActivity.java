package com.naca.calender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.naca.calender.databinding.CalenderListBinding;
import com.naca.calender.ui.adapter.CalendarAdapter;
import com.naca.calender.ui.viewmodel.CalendarListViewModel;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private CalenderListBinding binding;
    private CalendarAdapter calendarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVariable(BR.model, new ViewModelProvider(this).get(CalendarListViewModel.class));
        binding.setLifecycleOwner(this);

        binding.getModel().initCalendarList();

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(7, StaggeredGridLayoutManager.VERTICAL);
        calendarAdapter = new CalendarAdapter();
        binding.paperCalendar.setLayoutManager(manager);
        binding.paperCalendar.setAdapter(calendarAdapter);
        observe();

    }

    private void observe(){
        binding.getModel().mCalenderList.observe(this, new Observer<ArrayList<Object>>() {
            @Override
            public void onChanged(ArrayList<Object> objects) {
                calendarAdapter.submitList(objects);
                if (binding.getModel().mCenterPosition > 0){
                    binding.paperCalendar.scrollToPosition(binding.getModel().mCenterPosition);
                }
            }
        });
    }
}