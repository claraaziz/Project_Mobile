package com.example.projectmobile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    public static final String LOG_TAG ="Key";
    EditText name,age,height,weight;
    RadioGroup gender;
    ImageView image;
    Button upload;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        height=findViewById(R.id.height);
        weight=findViewById(R.id.weight);
        gender=findViewById(R.id.gender);
        image=findViewById(R.id.image);
        upload=findViewById(R.id.upload);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });
        Log.d(LOG_TAG,"OnCreate");
    }
    public void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode==PICK_IMAGE){
            assert data != null;
            imageUri=data.getData();
            Toast.makeText(this,"Image Uploaded",Toast.LENGTH_LONG).show();
            //image.setImageURI(imageUri);
        }
    }

    public void launchProfileActivity(View view){
        Log.d(LOG_TAG,"Button Clicked!");
        Intent i = new Intent(this,ProfileActivity.class);
        Bundle extras = new Bundle();
        String n = name.getText().toString();
        Integer a= Integer.parseInt(age.getText().toString());
        Integer h=Integer.parseInt(height.getText().toString());
        Integer w=Integer.parseInt(weight.getText().toString());
        extras.putString("name",n);
        extras.putInt("age",a);
        extras.putInt("height",h);
        extras.putInt("weight",w);
        extras.putParcelable("ImgUri",imageUri);
        i.putExtras(extras);
        startActivity(i);
    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit=sp.edit();

        //Save preferences as (key,value)
        myEdit.putString("name",name.getText().toString());
        myEdit.putInt("age",Integer.parseInt(age.getText().toString()));
        myEdit.putInt("height",Integer.parseInt(height.getText().toString()));
        myEdit.putInt("weight",Integer.parseInt(weight.getText().toString()));
        myEdit.putInt("gender",gender.indexOfChild(findViewById(gender.getCheckedRadioButtonId())));
        myEdit.putString("image",imageUri.toString());
        myEdit.apply();
        Log.d(LOG_TAG,"onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MySharedPref",MODE_PRIVATE);

        //Restore preferences
        String s= sh.getString("name","");
        String imgUri=sh.getString("image","");
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
        imageUri=Uri.parse(imgUri);
        Log.d(LOG_TAG,"onResume");
    }
    //Activity lifecycle
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