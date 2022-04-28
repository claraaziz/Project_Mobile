package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class ProfileActivity extends AppCompatActivity {

    TextView n,a,w,h;
    String name;
    int age;
    int weight;
    int height;
    ImageView img;
    Uri imgUri;
    private JobScheduler mScheduler;
    private static final int JOB_ID = 0;
    Switch idle,charging;
    private SeekBar seekBar;
    ImageView home, workout, schedule, profile;
    public static final String LOG_TAG ="Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        n=findViewById(R.id.n);
        a=findViewById(R.id.a);
        h=findViewById(R.id.h);
        w=findViewById(R.id.w);
        idle=findViewById(R.id.idleSwitch);
        charging=findViewById(R.id.chargingSwitch);
        seekBar=findViewById(R.id.seekBar);
        img=findViewById(R.id.imageView);
        final TextView seekBarProgress=findViewById(R.id.seekBarProgress);
        Bundle extras=getIntent().getExtras();
        name=extras.getString("name");
        age=extras.getInt("age");
        height=extras.getInt("height");
        weight=extras.getInt("weight");
        imgUri=extras.getParcelable("ImgUri");
        img.setImageURI(imgUri);
        n.setText(name);
        a.setText("     "+age+" years");
        h.setText("     "+height+" cm");
        w.setText("     "+weight+" kg");

        //Updates the TextView with the value from the seekbar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(i>0){
                    seekBarProgress.setText(i+" s");
                }
                else{
                    seekBarProgress.setText("Not Set");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        home =  findViewById(R.id.home);
        workout =  findViewById(R.id.workout);
        schedule =  findViewById(R.id.schedule);
        profile =  findViewById(R.id.profile);

        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workoutPage = new Intent(ProfileActivity.this, Workout1.class);
                startActivity(workoutPage);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workoutPage = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(workoutPage);
            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent schedulePage = new Intent(ProfileActivity.this, scheduleClasses.class);
                startActivity(schedulePage);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profilePage = new Intent(ProfileActivity.this, ProfileActivity.class);
                startActivity(profilePage);
            }
        });
        Log.d(LOG_TAG,"onCreate");
    }
    public void scheduleJob(View view){
        int seekBarInteger = seekBar.getProgress();
        boolean seekBarSet = seekBarInteger > 0;
        RadioGroup networkOptions=findViewById(R.id.networkOptions);
        int selectedNetworkID=networkOptions.getCheckedRadioButtonId();
        int selectedNetworkOption= JobInfo.NETWORK_TYPE_NONE;
        switch (selectedNetworkID){
            case R.id.noNetwork:
                selectedNetworkOption=JobInfo.NETWORK_TYPE_NONE;
                break;
            case R.id.anyNetwork:
                selectedNetworkOption=JobInfo.NETWORK_TYPE_ANY;
                break;
            case R.id.wifiNetwork:
                selectedNetworkOption=JobInfo.NETWORK_TYPE_UNMETERED;
                break;
        }
        mScheduler=(JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        ComponentName serviceName=new ComponentName(getPackageName(),
                NotificationJobService.class.getName());
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID,serviceName);
        builder.setRequiredNetworkType(selectedNetworkOption);
        boolean constraintSet=(selectedNetworkOption!=JobInfo.NETWORK_TYPE_NONE)
                || charging.isChecked()|| idle.isChecked()|| seekBarSet;
        if(constraintSet){

            //Schedule the job and notify the user
            JobInfo myJobInfo= builder.build();
            mScheduler.schedule(myJobInfo);
            Toast.makeText(this, "Job Scheduled, job will run when " +
                    "the constraints are met.", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Please set at least one constraint",Toast.LENGTH_LONG).show();
        }
        builder.setRequiresDeviceIdle(idle.isChecked());
        builder.setRequiresCharging(charging.isChecked());

        if (seekBarSet) {
            builder.setOverrideDeadline(seekBarInteger * 1000);
        }
    }
    public void cancelJobs(View view){
        if(mScheduler!=null){
            mScheduler.cancelAll();
            mScheduler=null;
            Toast.makeText(this,"Job Cancelled",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        if (mScheduler != null) {
            mScheduler.cancelAll();
            mScheduler = null;
        }
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
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

}