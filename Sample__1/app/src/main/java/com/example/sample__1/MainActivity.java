package com.example.sample__1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.*;

import com.android.volley.*;
import com.android.volley.toolbox.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] myDataset = {"1", "2"};
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //1. activity가 로딩 -> 정보를 받아온다
        queue = Volley.newRequestQueue(this);
        getNews();

        //2. 정보를 어댑터에 넘겨준다


        //3. 어댑터는 세팅한다
    }

    public void getNews(){

        // Instantiate the RequestQueue.

        String url = "https://newsapi.org/v2/top-headlines?country=kr&apiKey=4de1ce6eddc347df89271a8059f1d3ef";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jobj = new JSONObject(response);

                            JSONArray newsArray = jobj.getJSONArray("articles");
                            List<NewsData> news = new ArrayList<>();
                            for(int i = 0;i<newsArray.length();i++){
                                JSONObject obj = newsArray.getJSONObject(i);

                                Log.d("NEWS", obj.toString());

                                NewsData newsData = new NewsData();

                                newsData.setTitle(obj.getString("title"));
                                newsData.setContent(obj.getString("content"));
                                newsData.setUrlToImage(obj.getString("urlToImage"));

                                news.add(newsData);
                            }
                            mAdapter = new MyAdapter(news);
                            recyclerView.setAdapter(mAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}
