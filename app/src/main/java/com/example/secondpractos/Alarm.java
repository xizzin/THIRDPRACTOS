package com.example.secondpractos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class Alarm extends BroadcastReceiver {
    /*
        при окончании таймера вывод вибрации и сообщения
     */
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context, "БУДИЛЬНИК!", Toast.LENGTH_LONG).show();
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
        /*
        vibrator.vibrate(500); is deprecated as of api26
         */
        Uri path = Uri.parse("android.resource://" + context.getPackageName() + "/raw/price.mp3");
        RingtoneManager.setActualDefaultRingtoneUri(
                context.getApplicationContext(), RingtoneManager.TYPE_RINGTONE, path
        );
        Ringtone r = RingtoneManager.getRingtone(context.getApplicationContext(), path);
        r.play();
    }
}
