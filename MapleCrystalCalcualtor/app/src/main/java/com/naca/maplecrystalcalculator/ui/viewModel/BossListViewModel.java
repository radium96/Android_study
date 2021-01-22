package com.naca.maplecrystalcalculator.ui.viewModel;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.ImageView;

import androidx.lifecycle.ViewModel;

import com.naca.maplecrystalcalculator.data.Boss;
import com.naca.maplecrystalcalculator.data.TSLiveData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class BossListViewModel extends ViewModel {

    public TSLiveData<Integer> peopleNum = new TSLiveData<>();
    public TSLiveData<String> difficulty = new TSLiveData<>();
    public TSLiveData<Integer> count = new TSLiveData<>();
    public TSLiveData<ImageView> image = new TSLiveData<>();
    public Context mContext;
    public String json;
    public TSLiveData<ArrayList<Boss>> bossList = new TSLiveData<>();

    public BossListViewModel(Context context){
        mContext = context;
        getJson();
        jsonParsing(json);
    }

    public void setBossList(int position) {

    }

    public void getJson() {
        json = "";

        try {
            InputStream is = mContext.getAssets().open("weekboss.json");
            int fileSize = is.available();

            byte[] buffer = new byte[fileSize];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException e){
            e.printStackTrace();;
        }
    }

    private void jsonParsing(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONArray bossArray = jsonObject.getJSONArray("boss");

            ArrayList<Boss> bossArrayList = new ArrayList<>();

            for(int i=0; i<bossArray.length(); i++){
                JSONObject bossObject = bossArray.getJSONObject(i);

                Boss boss = new Boss();

                boss.setBossName(bossObject.getString("boss"));
                boss.setDifficulty(bossObject.getJSONArray("difficulty"));
                boss.setCount(bossObject.getJSONArray("count"));

                bossArrayList.add(boss);
            }

            bossList.setValue(bossArrayList);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
