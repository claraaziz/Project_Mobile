package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    ImageView home, workout, schedule, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent i=getIntent();

        home =  findViewById(R.id.home);
        workout =  findViewById(R.id.workout);
        schedule =  findViewById(R.id.schedule);
        profile =  findViewById(R.id.profile);

        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workoutPage = new Intent(HomeActivity.this, Workout1.class);
                startActivity(workoutPage);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workoutPage = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(workoutPage);
            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent schedulePage = new Intent(HomeActivity.this, scheduleClasses.class);
                startActivity(schedulePage);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profilePage = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(profilePage);
            }
        });
    }
//
//    public void ongohome(View view) {
//        Intent i =new Intent(this,HomeActivity.class);
//        startActivity(i);
//    }
//
//    public void ongogym(View view) {
//        Intent i =new Intent(this,Workout1.class);
//        startActivity(i);
//    }
//
//    public void ongosession(View view) {
//        Intent i =new Intent(this,scheduleClasses.class);
//        startActivity(i);
//    }
//
//    public void ongoprofile(View view) {
//        Intent i =new Intent(this,ProfileActivity.class);
//        startActivity(i);
//    }
//
}