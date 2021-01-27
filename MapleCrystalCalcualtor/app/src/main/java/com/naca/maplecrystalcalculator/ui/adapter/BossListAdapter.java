package com.naca.maplecrystalcalculator.ui.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.*;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.naca.maplecrystalcalculator.R;
import com.naca.maplecrystalcalculator.data.Boss;
import com.naca.maplecrystalcalculator.databinding.BossRowBinding;
import com.naca.maplecrystalcalculator.ui.viewModel.BossListViewModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class BossListAdapter extends RecyclerView.Adapter<BossListAdapter.BossRowHolder> {

    private List<Boss> boss;

    private Context mContext;

    public class BossRowHolder extends RecyclerView.ViewHolder {
        private BossRowBinding binding;

        public BossRowHolder(@NonNull BossRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    switch (v.getId()) {
                        case R.id.peoplenum:
                            final List<String> ListItems = new ArrayList<>();
                            ListItems.add("0");
                            ListItems.add("1");
                            ListItems.add("2");
                            ListItems.add("3");
                            ListItems.add("4");
                            ListItems.add("5");
                            ListItems.add("6");
                            final CharSequence[] items = ListItems.toArray(new String[ListItems.size()]);

                            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                            builder.setTitle("인원수");
                            builder.setItems(items, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int position) {
                                    int selectedItem = Integer.parseInt(items[position].toString());
                                }
                            });
                            builder.show();
                            break;
                        case R.id.difficulty:
                            break;
                        case R.id.count:
                            break;
                    }

                }
            });
        }

        private void setViewModel(BossListViewModel model){
            binding.setModel(model);
            binding.executePendingBindings();
        }
    }

    @NonNull
    @Override
    public BossListAdapter.BossRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BossRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_boss, parent, false);

        mContext = parent.getContext();

        return new BossRowHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BossRowHolder holder, int position) {

        BossListViewModel model = new BossListViewModel(mContext);
        

        holder.setViewModel(model);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
