package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Workout1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout1);
    }
    public void ongohome(View view) {
        Intent i =new Intent(this,HomeActivity.class);
    }

    public void ongogym(View view) {
        Intent i =new Intent(this,Workout1.class);

    }

    public void ongosession(View view) {
        Intent i =new Intent(this,scheduleClasses.class);
    }

    public void ongoprofile(View view) {
        Intent i =new Intent(this,ProfileActivity.class);
    }


}