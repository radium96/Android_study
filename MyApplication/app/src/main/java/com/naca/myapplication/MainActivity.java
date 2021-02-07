package com.naca.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

import com.naca.myapplication.databinding.BossMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BossMainBinding binding;
    private BossListAdapter mAdapter;
    private String json;
    private ObservableArrayList<Boss> bossArrayList = new ObservableArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mAdapter = new BossListAdapter();
        binding.recyclerview.setAdapter(mAdapter);
        binding.setBossList(bossArrayList);

        getJson();
    }

    public void getJson() {
        json = "";
        AssetManager am = getAssets();

        try {
            InputStream is = am.open("json/weekboss.json");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);

            StringBuffer buffer = new StringBuffer();
            String line = reader.readLine();
            while (line != null){
                buffer.append(line+"\n");
                line = reader.readLine();
            }

            json = buffer.toString();
        } catch (IOException e){
            e.printStackTrace();;
        }

        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONArray bossArray = jsonObject.getJSONArray("boss");
            Log.d("TEST", Integer.toString(bossArray.length()));

            for(int i = 0;i<bossArray.length(); i++) {
                JSONObject bossObject = bossArray.getJSONObject(i);

                Boss boss = new Boss();

                boss.setBossName(bossObject.getString("name"));

                JSONArray diffArray = bossObject.getJSONArray("difficulty");
                ArrayList<String> diffArr = new ArrayList<>();
                for(int j = 0;j<diffArray.length();j++){
                    diffArr.add(diffArray.get(j).toString());
                }
                boss.setDiffArr(diffArr);

                JSONArray countArray = bossObject.getJSONArray("count");
                ArrayList<String> countArr = new ArrayList<>();
                for(int j = 0;j<countArray.length();j++){
                    countArr.add(countArray.get(j).toString());
                }
                boss.setCountArr(countArr);

                bossArrayList.add(boss);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}