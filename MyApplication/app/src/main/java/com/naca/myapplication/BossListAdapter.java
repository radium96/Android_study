package com.naca.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.naca.myapplication.databinding.BossRowBinding;

import java.util.ArrayList;
import java.util.List;

public class BossListAdapter extends RecyclerView.Adapter<BossListAdapter.BindingViewHolder> {

    private List<Boss> bossList;
    private Context mContext;
    public static OnItemClickListener mListener = null;

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public BossListAdapter(){
        this.bossList = new ArrayList<>();
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BossRowBinding binding = BossRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        mContext = parent.getContext();

        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder holder, int position) {
        Boss boss = bossList.get(position);
        holder.bind(boss);
    }

    @Override
    public int getItemCount() {
        return bossList.size();
    }

    public void setItem(List<Boss> boss) {
        this.bossList = boss;
        notifyDataSetChanged();
    }

    public class BindingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        BossRowBinding binding;

        public BindingViewHolder(@NonNull BossRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            TextView peoplenum = binding.peoplenum;
            TextView difficulty = binding.difficulty;
            TextView count = binding.count;

            peoplenum.setOnClickListener(this);
            difficulty.setOnClickListener(this);
            count.setOnClickListener(this);
        }

        public void bind(Boss boss) {
            binding.setVariable(BR.boss, boss);
        }

        @Override
        public void onClick(View v) {

            int pos = getAdapterPosition();

            switch (v.getId()) {
                case R.id.peoplenum:
                    final List<String> peopleNumListItems = new ArrayList<>();
                    for(int i = 0;i<7;i++){
                        peopleNumListItems.add(Integer.toString(i));
                    }
                    final CharSequence[] peopleNumItems = peopleNumListItems.toArray(new String[peopleNumListItems.size()]);

                    AlertDialog.Builder peopleNumBuilder = new AlertDialog.Builder(mContext);
                    peopleNumBuilder.setTitle("인원수");
                    peopleNumBuilder.setItems(peopleNumItems, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int position) {
                            String onclick = peopleNumItems[position].toString();
                            bossList.get(pos).setPeopleNum(onclick);
                        }
                    });
                    peopleNumBuilder.show();
                    break;
                case R.id.difficulty:
                    final List<String> diffListItems = bossList.get(pos).getDiffArr();

                    final CharSequence[] diffItems = diffListItems.toArray(new String[diffListItems.size()]);
                    Log.d("TEST", diffItems.toString());

                    AlertDialog.Builder diffBuilder = new AlertDialog.Builder(mContext);
                    diffBuilder.setTitle("난이도");
                    diffBuilder.setItems(diffItems, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int position) {
                            String onclick = diffItems[position].toString();
                            bossList.get(pos).setDifficulty(onclick);
                            Log.d("TEST", onclick);
                        }
                    });
                    diffBuilder.show();
                    break;

                case R.id.count:
                    final List<String> countListItems = bossList.get(pos).getCountArr();

                    final CharSequence[] countItems = countListItems.toArray(new String[countListItems.size()]);
                    Log.d("TEST", countItems.toString());

                    AlertDialog.Builder countBuilder = new AlertDialog.Builder(mContext);
                    countBuilder.setTitle("횟수");
                    countBuilder.setItems(countItems, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int position) {
                            String onclick = countItems[position].toString();
                            bossList.get(pos).setCount(onclick);
                            Log.d("TEST", onclick);
                        }
                    });
                    countBuilder.show();
                    break;
            }

        }
    }

}
