package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Workout extends AppCompatActivity {

    Button b1, b2, b3;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        b1= findViewById(R.id.imageButton);
        b2= findViewById(R.id.imageButton2);
        b3= findViewById(R.id.imageButton3);
        b1.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v){
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String body = "Your body here";
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
                String body = "Your body here";
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
                String body = "Your body here";
                String sub = "Your Subject";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
                myIntent.putExtra(Intent.EXTRA_TEXT,body);
                startActivity(Intent.createChooser(myIntent, "Share Using"));
            }
        });
    }
    private void setupHyperlink() {
        TextView link1 = findViewById(R.id.yoga);
        link1.setMovementMethod(LinkMovementMethod.getInstance());
        TextView link2 = findViewById(R.id.hiit);
        link2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView link3 = findViewById(R.id.boxing);
        link3.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
