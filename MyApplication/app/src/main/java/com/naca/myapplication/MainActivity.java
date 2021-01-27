package com.naca.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;

import android.content.Context;
import android.os.Bundle;

import com.naca.myapplication.databinding.BossMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BossMainBinding binding;
    private BossListAdapter mAdapter;
    private String json;
    private ObservableArrayList<Boss> bossArrayList = new ObservableArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        getJson();
//        jsonParsing(json);

        mAdapter = new BossListAdapter();
        binding.recyclerview.setAdapter(mAdapter);
        binding.setBossList(bossArrayList);

        bossData();
    }

    private void bossData() {
        bossArrayList.add(new Boss("banban", "easy", "1", "1"));
        bossArrayList.add(new Boss("banban", "easy", "1", "1"));
    }

//    public void getJson() {
//        json = "";
//
//        try {
//            InputStream is = getAssets().open("weekboss.json");
//            int fileSize = is.available();
//
//            byte[] buffer = new byte[fileSize];
//            is.read(buffer);
//            is.close();
//
//            json = new String(buffer, "UTF-8");
//
//        } catch (IOException e){
//            e.printStackTrace();;
//        }
//    }
//
//    private void jsonParsing(String json) {
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//
//            JSONArray bossArray = jsonObject.getJSONArray("boss");
//
//            for(int i=0; i<bossArray.length(); i++){
//                JSONObject bossObject = bossArray.getJSONObject(i);
//
//                Boss boss = new Boss();
//
//                boss.setBossName(bossObject.getString("boss"));
//                boss.setDifficulty(bossObject.getJSONArray("difficulty"));
//                boss.setCount(bossObject.getJSONArray("count"));
//
//                bossArrayList.add(boss);
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
}