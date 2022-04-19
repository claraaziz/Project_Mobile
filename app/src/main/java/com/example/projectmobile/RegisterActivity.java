package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RegisterActivity extends AppCompatActivity {

    public static final String LOG_TAG ="Key";
    public static final String EXTRA_MESSAGE1=
            "com.example.android.myapplication3.extra.MESSAGE";
    public static final String EXTRA_MESSAGE2=
            "com.example.android.myapplication3.extra.MESSAGE";
    public static final String EXTRA_MESSAGE3=
            "com.example.android.myapplication3.extra.MESSAGE";
    public static final String EXTRA_MESSAGE4=
            "com.example.android.myapplication3.extra.MESSAGE";
    EditText name,age,height,weight;
    RadioGroup gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        height=findViewById(R.id.height);
        weight=findViewById(R.id.weight);
        gender=findViewById(R.id.gender);
    }
    public void launchProfileActivity(View view){
        Log.d(LOG_TAG,"Button Clicked!");
        Intent i = new Intent(this,ProfileActivity.class);
        String n = name.getText().toString();
        Integer a= Integer.parseInt(age.getText().toString());
        Integer h=Integer.parseInt(height.getText().toString());
        Integer w=Integer.parseInt(weight.getText().toString());
        i.putExtra(EXTRA_MESSAGE1,n);
        i.putExtra(EXTRA_MESSAGE2,a);
        i.putExtra(EXTRA_MESSAGE3,h);
        i.putExtra(EXTRA_MESSAGE4,w);
        startActivity(i);
    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit=sp.edit();
        myEdit.putString("name",name.getText().toString());
        myEdit.putInt("age",Integer.parseInt(age.getText().toString()));
        myEdit.putInt("height",Integer.parseInt(height.getText().toString()));
        myEdit.putInt("weight",Integer.parseInt(weight.getText().toString()));
        myEdit.putInt("gender",gender.indexOfChild(findViewById(gender.getCheckedRadioButtonId())));
        myEdit.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String s= sh.getString("name","");
        int a = sh.getInt("age",0);
        int h = sh.getInt("height",0);
        int w = sh.getInt("weight",0);
        int i = sh.getInt("gender",-1);
        if( i >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.gender)).getChildAt(i)).setChecked(true);
        }
        name.setText(s);
        age.setText(String.valueOf(a));
        height.setText(String.valueOf(h));
        weight.setText(String.valueOf(w));
    }
}