package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    private BroadcastReceiver MyReciever=null;
    public static final String LOG_TAG ="Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //keep track of CONNECTIVITY_ACTION like internet connectivity on/off
        MyReciever=new MyReciever();
        broadcastIntent();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(homeIntent);
                finish();}
        }, SPLASH_TIME_OUT);
        Log.d(LOG_TAG,"onCreate");
    }
    public void broadcastIntent(){
        registerReceiver(MyReciever,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    //Activity lifecycle
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(MyReciever);
        Log.d(LOG_TAG,"onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }

}