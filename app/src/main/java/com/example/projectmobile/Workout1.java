package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Workout1 extends AppCompatActivity {
    ImageButton b1, b2, b3;
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
    }

    private void setupHyperlink() {
        TextView link1 = findViewById(R.id.yoga);
        link1.setMovementMethod(LinkMovementMethod.getInstance());
        TextView link2 = findViewById(R.id.hiit);
        link2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView link3 = findViewById(R.id.boxing);
        link3.setMovementMethod(LinkMovementMethod.getInstance());
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