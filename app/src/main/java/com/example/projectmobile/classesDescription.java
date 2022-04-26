package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectmobile.R;

public class classesDescription extends AppCompatActivity {

    private TextView tv_container,tv_content;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_description);

        tv_container = findViewById(R.id.container);
        tv_content =  findViewById(R.id.content);
        img = findViewById(R.id.imageView2);

        tv_container.setText(getIntent().getStringExtra("containerINTENT"));
        tv_content.setText(getIntent().getStringExtra("contentINTENT"));
        img.setImageResource(getIntent().getIntExtra("imageINTENT",R.drawable.yoga));







    }

}
