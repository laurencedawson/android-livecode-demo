package com.laurencedawson.livecode;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class CustomApplication extends Application {
  
  // Tag to be used with Log.d
  public static final String TAG = "Livecode";

  /**
   * Create a static instance of the RequestQueue, this will be accessible throughout the app by
   * calling CustomApplication.requestQueue
   * 
   * 
   * RequestQueue.java
   * A request dispatch queue with a thread pool of dispatchers. Calling add(Request) will enqueue 
   * the given Request for dispatch, resolving from either cache or network on a worker thread, 
   * and then delivering a parsed response on the main thread.
   * 
   * http://afzalive.github.io/volley/com/android/volley/RequestQueue.html
   */
  public static RequestQueue requestQueue;
  
  @Override
  public void onCreate() {
    super.onCreate();
    
    // Create an instance of request queue
    requestQueue = Volley.newRequestQueue(this);
  }
  
}
