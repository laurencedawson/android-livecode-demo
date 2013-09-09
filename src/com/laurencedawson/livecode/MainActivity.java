package com.laurencedawson.livecode;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Create a simple JsonObjectRequest
    CustomApplication.requestQueue.add(new JsonObjectRequest(
        "http://reddit.com/r/worldnews.json", null, new Listener<JSONObject>() {
          
          @Override
          public void onResponse(JSONObject response) {
            Log.d(CustomApplication.TAG, response.toString());
          }
          
        }, null));
  }

}
