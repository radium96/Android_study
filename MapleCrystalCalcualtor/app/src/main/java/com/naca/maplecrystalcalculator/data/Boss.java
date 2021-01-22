package com.naca.maplecrystalcalculator.data;

import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Boss {

    private ImageView image;
    private String bossName;
    private ArrayList<String> difficulty;
    private ArrayList<Integer> count;

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public ArrayList<String> getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(JSONArray difficulty) throws JSONException {
        for (int i = 0;i<difficulty.length();i++){
            JSONObject temp = difficulty.getJSONObject(i);
            this.difficulty.add(temp.toString());
        }
    }

    public ArrayList<Integer> getCount() {
        return count;
    }

    public void setCount(JSONArray count) throws JSONException {
        for (int i = 0;i<count.length();i++){
            JSONObject temp = count.getJSONObject(i);
            this.count.add(Integer.parseInt(temp.toString()));
        }
    }
}
