package com.laurencedawson.livecode;

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
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    // Grab the ListView
    this.mListView = (ListView) findViewById(R.id.news_list);

    // Create a simple JsonObjectRequest
    CustomApplication.requestQueue.add(new JsonObjectRequest(
        "http://reddit.com/r/worldnews.json", null, 
        
        // Create a Response Listener object, the data returned by calling the aforementioned URL
        // will be returned in a JSON object to this listener on the UI thread.
        new Listener<JSONObject>() {
          
          @Override
          public void onResponse(JSONObject response) {
            Log.d(CustomApplication.TAG, response.toString());
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