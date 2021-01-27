package com.naca.myapplication;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Boss {

//    private ImageView image;
    private String bossName;
    private String difficulty;
    private String count;
    private String peopleNum;

    public Boss(){
    }

    public Boss(String bossName){
        this.bossName = bossName;
    }

    public Boss(String bossName, String difficulty, String count){
        this.bossName = bossName;
        this.difficulty = difficulty;
        this.count = count;
    }

    public Boss(String bossName, String difficulty, String count, String peopleNum){
        this.bossName = bossName;
        this.difficulty = difficulty;
        this.count = count;
        this.peopleNum = peopleNum;
    }

//    public ImageView getImage() {
//        return image;
//    }
//
//    public void setImage(ImageView image) {
//        this.image = image;
//    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(String peopleNum) {
        this.peopleNum = peopleNum;
    }

    //    public ArrayList<String> getDifficulty() {
//        return difficulty;
//    }
//
//    public void setDifficulty(JSONArray difficulty) throws JSONException {
//        for (int i = 0;i<difficulty.length();i++){
//            JSONObject temp = difficulty.getJSONObject(i);
//            this.difficulty.add(temp.toString());
//        }
//    }
//
//    public ArrayList<Integer> getCount() {
//        return count;
//    }
//
//    public void setCount(JSONArray count) throws JSONException {
//        for (int i = 0;i<count.length();i++){
//            JSONObject temp = count.getJSONObject(i);
//            this.count.add(Integer.parseInt(temp.toString()));
//        }
//    }


}
