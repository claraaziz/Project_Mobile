package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView n,a,w,h;
    String name,age,weight,height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        n=findViewById(R.id.n);
        a=findViewById(R.id.a);
        h=findViewById(R.id.h);
        w=findViewById(R.id.w);
        Intent i = getIntent();
        name=i.getStringExtra(RegisterActivity.EXTRA_MESSAGE1);
        age=i.getStringExtra(RegisterActivity.EXTRA_MESSAGE2);
        height=i.getStringExtra(RegisterActivity.EXTRA_MESSAGE3);
        weight=i.getStringExtra(RegisterActivity.EXTRA_MESSAGE4);
        n.setText(name);
        a.setText(age+" years");
        h.setText(height+"cm");
        w.setText(weight+"kg");
    }
}