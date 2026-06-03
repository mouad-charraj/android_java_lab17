package com.example.lab17;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            boolean isAirplaneOn = intent.getBooleanExtra("state", false);
            String message = isAirplaneOn 
                ? "Mode Avion ACTIVÉ _mouad" 
                : "Mode Avion DÉSACTIVÉ _mouad";
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }
}
