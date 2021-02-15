package com.naca.myapplication;

import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Boss {

    private MutableLiveData<Integer> image = new MutableLiveData<>();
    private MutableLiveData<String> bossName = new MutableLiveData<>();
    private MutableLiveData<String> difficulty = new MutableLiveData<>();
    private MutableLiveData<String> count = new MutableLiveData<>();
    private MutableLiveData<String> peopleNum = new MutableLiveData<>();

    private MutableLiveData<ArrayList<String>> diffArr = new MutableLiveData<>();
    private MutableLiveData<ArrayList<String>> countArr = new MutableLiveData<>();


    public Boss(){
    }

    public Boss(String bossName){
        this.bossName.setValue(bossName);
    }

    public Boss(String bossName, String difficulty, String count){
        this.bossName.setValue(bossName);
        this.difficulty.setValue(difficulty);
        this.count.setValue(count);
    }

    public Boss(String bossName, String difficulty, String count, String peopleNum){
        this.bossName.setValue(bossName);
        this.difficulty.setValue(difficulty);
        this.count.setValue(count);
        this.peopleNum.setValue(peopleNum);
    }

    public int getImage() {
        return image.getValue();
    }

    public void setImage(int image) {
        this.image.setValue(image);
    }

    public String getBossName() {
        return bossName.getValue();
    }

    public void setBossName(String bossName) {
        this.bossName.setValue(bossName);
    }

    public String getDifficulty() {
        return difficulty.getValue();
    }

    public void setDifficulty(String difficulty) {
        this.difficulty.setValue(difficulty);
    }

    public String getCount() {
        return count.getValue();
    }

    public void setCount(String count) {
        this.count.setValue(count);
    }

    public String getPeopleNum() {
        return peopleNum.getValue();
    }

    public void setPeopleNum(String peopleNum) {
        this.peopleNum.setValue(peopleNum);
    }

    public ArrayList<String> getDiffArr() {
        return diffArr.getValue();
    }

    public void setDiffArr(ArrayList<String> diffArr) {
        this.diffArr.setValue(diffArr);
    }

    public ArrayList<String> getCountArr() {
        return countArr.getValue();
    }

    public void setCountArr(ArrayList<String> countArr) {
        this.countArr.setValue(countArr);
    }
}
