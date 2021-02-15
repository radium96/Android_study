package com.naca.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Resource;
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
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        context = getApplicationContext();

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

                Resources resources = context.getResources();
                String imageName = bossObject.getString("image");
                final int imageId = resources.getIdentifier(imageName, "drawable", context.getPackageName());
                Log.d("TEST1", Integer.toString(imageId));
                boss.setImage(imageId);

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