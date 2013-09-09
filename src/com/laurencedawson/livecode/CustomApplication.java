package com.laurencedawson.livecode;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class CustomApplication extends Application {

  /**
   * Create a static instance of the RequestQueue, this will be accessible throughout the app by
   * calling CustomApplication.requestQueue
   */
  public static RequestQueue requestQueue;
  
  @Override
  public void onCreate() {
    super.onCreate();
    
    // Create an instance of request queue
    requestQueue = Volley.newRequestQueue(this);
  }
  
}
