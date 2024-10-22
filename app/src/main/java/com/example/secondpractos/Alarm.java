package com.example.secondpractos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.Toast;

public class Alarm extends BroadcastReceiver {
    /*
        при окончании таймера вывод вибрации и сообщения
     */
    @Override
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context, "Время вышло!", Toast.LENGTH_LONG).show();
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));

        /*
        vibrator.vibrate(500); is deprecated as of api26
         */
    }
}
