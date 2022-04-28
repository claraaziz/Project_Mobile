package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Workout1 extends AppCompatActivity {
    ImageButton b1, b2, b3;
    ImageView home, workout, schedule, profile;
    public static final String LOG_TAG ="Key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout1);
        setupHyperlink();
        b1= findViewById(R.id.share1);
        b2= findViewById(R.id.share2);
        b3= findViewById(R.id.share3);
        b1.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v){
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String body = "https://www.youtube.com/watch?v=EDD4GxHVess";
                String sub = "Your Subject";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
                myIntent.putExtra(Intent.EXTRA_TEXT,body);
                startActivity(Intent.createChooser(myIntent, "Share Using"));
            }
        });
        b2.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v){
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String body = "https://www.youtube.com/watch?v=7DaE7pi5wfg";
                String sub = "Your Subject";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
                myIntent.putExtra(Intent.EXTRA_TEXT,body);
                startActivity(Intent.createChooser(myIntent, "Share Using"));
            }
        });
        b3.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v){
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String body = "https://www.youtube.com/watch?v=Ef6LwAaB3_E";
                String sub = "Your Subject";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
                myIntent.putExtra(Intent.EXTRA_TEXT,body);
                startActivity(Intent.createChooser(myIntent, "Share Using"));
            }
        });
        home =  findViewById(R.id.home);
        workout =  findViewById(R.id.workout);
        schedule =  findViewById(R.id.schedule);
        profile =  findViewById(R.id.profile);
        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workoutPage = new Intent(Workout1.this, Workout1.class);
                startActivity(workoutPage);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workoutPage = new Intent(Workout1.this, HomeActivity.class);
                startActivity(workoutPage);
            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent schedulePage = new Intent(Workout1.this, scheduleClasses.class);
                startActivity(schedulePage);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profilePage = new Intent(Workout1.this, ProfileActivity.class);
                startActivity(profilePage);
            }
        });
        Log.d(LOG_TAG,"onCreate");
    }

    private void setupHyperlink() {
        TextView link1 = findViewById(R.id.yoga);
        link1.setMovementMethod(LinkMovementMethod.getInstance());
        TextView link2 = findViewById(R.id.hiit);
        link2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView link3 = findViewById(R.id.boxing);
        link3.setMovementMethod(LinkMovementMethod.getInstance());
    }
    //Activity lifecycle
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause");
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