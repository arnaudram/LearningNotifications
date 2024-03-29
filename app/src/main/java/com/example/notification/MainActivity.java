package com.example.notification;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String CHANNEL_ID = "channel1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void simplenotification(View view) {

        NotificationChannel notificationChannel = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notificationChannel = new NotificationChannel("channel1", "basicNotification", NotificationManager.IMPORTANCE_DEFAULT);
        }
        Notifications.BasicNotification(this, "new basic notification", "baseId", notificationChannel, 1);
    }


    public void expendableNotification(View view) {
        NotificationChannel notificationChannel=null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            notificationChannel = new NotificationChannel("channel2", "expendable",
                    NotificationManager.IMPORTANCE_DEFAULT);

        }
        Notifications.expendableNotification(this, "expendableId",
                "Arnaud this is your first expendable notification so try to enjoy it", notificationChannel, 2);
    }
}
