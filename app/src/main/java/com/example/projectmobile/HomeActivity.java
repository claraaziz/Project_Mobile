package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void launchClassesActivity(View view) {
        Intent classesIntent = new Intent(this, Classes.class);
        startActivity(classesIntent);
    }

    public void launchWorkoutActivity(View view) {
        Intent workoutIntent = new Intent(this, Workout.class);
        startActivity(workoutIntent);
    }
}