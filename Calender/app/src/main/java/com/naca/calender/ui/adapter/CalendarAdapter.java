package com.naca.calender.ui.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.naca.calender.databinding.CalendarHeaderBinding;
//import com.naca.calender.databinding.DayItemBinding;
import com.naca.calender.databinding.EmptyDayBinding;
import com.naca.calender.databinding.ItemDayBinding;
import com.naca.calender.ui.viewmodel.CalendarViewModel;
import com.naca.calender.ui.viewmodel.CalenderHeaderViewModel;
import com.naca.calender.ui.viewmodel.EmptyViewModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class CalendarAdapter extends ListAdapter<Object, RecyclerView.ViewHolder> {
    private final int HEADER_TYPE = 0;
    private final int EMPTY_TYPE = 1;
    private final int DAY_TYPE = 2;

    public CalendarAdapter() {
        super(new DiffUtil.ItemCallback<Object>() {
            @Override
            public boolean areItemsTheSame(@NonNull Object oldItem, @NonNull Object newItem) {
                return oldItem == newItem;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Object oldItem, @NonNull Object newItem) {
                Gson gson = new Gson();
                return gson.toJson(oldItem).equals(gson.toJson(newItem));
            }
        });
    }

    public int getItemViewType(int position){
        Object item = getItem(position);
        if(item instanceof Long){
            return HEADER_TYPE;
        } else if (item instanceof String){
            return EMPTY_TYPE;
        } else {
            return DAY_TYPE;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        private CalendarHeaderBinding binding;


        private HeaderViewHolder(@NonNull CalendarHeaderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void setViewModel(CalenderHeaderViewModel model) {
            binding.setModel(model);
            binding.executePendingBindings();
        }
    }

    private class EmptyViewHolder extends RecyclerView.ViewHolder {
        private EmptyDayBinding binding;


        private EmptyViewHolder(@NonNull EmptyDayBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void setViewModel(EmptyViewModel model) {
            binding.setModel(model);
            binding.executePendingBindings();
        }
    }

    private class DayViewHolder extends RecyclerView.ViewHolder {
        private ItemDayBinding binding;


        private DayViewHolder(@NonNull ItemDayBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void setViewModel(CalendarViewModel model) {
            binding.setModel(model);
            binding.executePendingBindings();
        }
    }
}
