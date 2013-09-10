package com.laurencedawson.livecode;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

public class MainActivity extends Activity {

  private ListView mListView;
  private List<NewsItem> mNewsItems;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Grab the ListView
    this.mListView = (ListView) findViewById(R.id.news_list);

    // Create a new list to hold the news items
    mNewsItems = new ArrayList<NewsItem>();

    // Create a simple JsonObjectRequest
    CustomApplication.requestQueue.add(new JsonObjectRequest(
        "http://reddit.com/r/worldnews.json", null, 

        // Create a Response Listener object, the data returned by calling the aforementioned URL
        // will be returned in a JSON object to this listener on the UI thread.
        new Listener<JSONObject>() {

          @Override
          public void onResponse(JSONObject response) {

            try{

              JSONArray items = 
                  response.getJSONObject("data").getJSONArray("children");
              
              for(int i=0;i<items.length();i++){
                
                // Grab the child attributes JsonObject
                JSONObject child = items.getJSONObject(i).getJSONObject("data");
                
                // Create a new NewsItem and add it to the list
                NewsItem tempItem = new NewsItem(child.getString("title"), 
                    child.getString("author"));
                mNewsItems.add(tempItem);
                
                // Log the title
                Log.d(CustomApplication.TAG, child.getString("title"));
              }

            }catch(JSONException e){
              Log.e(CustomApplication.TAG, e.toString());
            }

          }

        }, 

        // Create a Response ErrorListener object, if anything goes wrong in the Request, this
        // callback will be called
        new Response.ErrorListener() {

          @Override
          public void onErrorResponse(VolleyError error) {
            Log.e(CustomApplication.TAG, error.toString());
          }

        }));
  }

}