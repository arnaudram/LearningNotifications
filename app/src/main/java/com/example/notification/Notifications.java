package com.example.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Notifications {


    public static void BasicNotification(Context context, String contentText, String channelId,NotificationChannel notificationChannel,int notificationId) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId);
        Bitmap largeIcon = BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_notification);
        builder.setSmallIcon(R.drawable.ic_announcement_black_24dp)
                .setLargeIcon(largeIcon)
                .setContentTitle("BasicNotificatiion")
                .setContentText(contentText)

                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        createNotificationChannel(context,notificationChannel);

        showNotification(context,builder,notificationId);
    }

    private static void showNotification(Context context,NotificationCompat.Builder builder,int notificationId) {
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(notificationId,builder.build());

    }

    private static void createNotificationChannel(Context context ,NotificationChannel notificationChannel) {


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(notificationChannel.getId(), notificationChannel.getName(), notificationChannel.getImportance());

            NotificationManager notificationManager =  context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public static void expendableNotification(Context context, String channelId, String contentText,
                                              NotificationChannel notificationChannel, int notificationId){

        NotificationCompat.Builder builder= new NotificationCompat.Builder(context,channelId)
                                   .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                                   .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                                   .setDefaults(NotificationCompat.DEFAULT_ALL)
                                   .setContentTitle("expendable Notification")
                                   .setContentText(contentText)
                                   .setStyle(new NotificationCompat.BigTextStyle().bigText(contentText));
        Bitmap largeIcon = BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_notification);
                                    builder.setLargeIcon(largeIcon).setStyle(new NotificationCompat.BigPictureStyle().bigPicture(largeIcon).bigLargeIcon(null));

                              createNotificationChannel(context, notificationChannel);

                              showNotification(context,builder,notificationId);




    }

}
