package com.example.lab17;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AirplaneModeReceiver airplaneReceiver_mouad;
    private boolean isRegistered_mouad = false;
    private Button btnToggle_mouad, btnSend_mouad;
    private TextView tvStatus_mouad;

    @Override
    protected void onCreate(Bundle savedInstanceState_mouad) {
        super.onCreate(savedInstanceState_mouad);
        setContentView(R.layout.activity_main);

        airplaneReceiver_mouad = new AirplaneModeReceiver();
        tvStatus_mouad = findViewById(R.id.tvStatus_mouad);
        btnToggle_mouad = findViewById(R.id.btnToggleAirplane_mouad);
        btnSend_mouad = findViewById(R.id.btnSendCustom_mouad);

        btnToggle_mouad.setOnClickListener(v_mouad -> toggleAirplane_mouad());
        btnSend_mouad.setOnClickListener(v_mouad -> sendCustom_mouad());
    }

    private void toggleAirplane_mouad() {
        if (!isRegistered_mouad) {
            IntentFilter filter_mouad = new IntentFilter();
            filter_mouad.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
            
            registerReceiver(airplaneReceiver_mouad, filter_mouad);
            isRegistered_mouad = true;
            tvStatus_mouad.setText("Status : Receiver Mode Avion ACTIVÉ _mouad");
            btnToggle_mouad.setText("Désactiver Receiver Avion _mouad");
        } else {
            unregisterReceiver(airplaneReceiver_mouad);
            isRegistered_mouad = false;
            tvStatus_mouad.setText("Status : Receiver Mode Avion DÉSACTIVÉ _mouad");
            btnToggle_mouad.setText("Activer Receiver Avion _mouad");
        }
    }

    private void sendCustom_mouad() {
        Intent intent_mouad = new Intent("com.example.lab17.CUSTOM_EVENT");
        intent_mouad.putExtra("message", "Message de Mouad !");
        intent_mouad.setPackage(getPackageName());
        sendBroadcast(intent_mouad);
        
        Toast.makeText(this, "Custom Broadcast envoyé par _mouad", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        if (isRegistered_mouad) {
            unregisterReceiver(airplaneReceiver_mouad);
        }
        super.onDestroy();
    }
}
