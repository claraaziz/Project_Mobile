package com.example.projectmobile;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.projectmobile.MainActivity;

//The Service that JobScheduler runs once the conditions are met
//In this case it posts a notification
public class NotificationJobService extends JobService {

    NotificationManager mNotifyManager;

    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";

    //Creates a Notification channel, for OREO and higher
    public void createNotificationChannel() {

        mNotifyManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //Check on SDK version
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {

            //Create the NotificationChannel with all the parameters
            NotificationChannel notificationChannel = new NotificationChannel
                    (PRIMARY_CHANNEL_ID,
                            "Job Service notification",
                            NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.setDescription("Notifications from Job Service");

            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }


    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        //Create the notification channel
        createNotificationChannel();

        //Set up the notification content intent to launch the app when clicked
        PendingIntent contentPendingIntent = PendingIntent.getActivity
                (this, 0, new Intent(this, ProfileActivity.class),
                        PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder
                (this, PRIMARY_CHANNEL_ID)
                .setContentTitle("Stay healthy")
                .setContentText("Don't forget to workout")
                .setContentIntent(contentPendingIntent)
                .setSmallIcon(android.R.drawable.ic_popup_reminder)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true);

        mNotifyManager.notify(0, builder.build());
        return false;

    }

    //onStopJob() returns true, because if the job fails,
    // you want the job to be rescheduled instead of dropped
    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}