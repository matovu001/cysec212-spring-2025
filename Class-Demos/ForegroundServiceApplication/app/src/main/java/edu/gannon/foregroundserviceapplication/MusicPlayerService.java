package edu.gannon.foregroundserviceapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.core.app.NotificationCompat;

public class MusicPlayerService extends Service {

    private static final String CHANNEL_ID = MusicPlayerService.class.getSimpleName();
    MediaPlayer mPlayer;

    public MusicPlayerService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        mPlayer.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        createNotificationChannel();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("CYSEC212 Service")
                .setContentText("Playing music...")
                .build();

        startForeground(1, notification);
        mPlayer.start();

        return START_STICKY;
    }

    private void createNotificationChannel()
    {
        NotificationChannel serviceChannel = new NotificationChannel(
                CHANNEL_ID,
                "Music Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
        );
        NotificationManager manager = getSystemService(NotificationManager.class);
        if (manager != null) {
            manager.createNotificationChannel(serviceChannel);
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}