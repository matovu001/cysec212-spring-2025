package edu.gannon.broadcastreceiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PowerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String message;
        String intentAction = intent.getAction();

        switch (intentAction) {
            case Intent.ACTION_POWER_CONNECTED:
                message = "Phone connected to a power outlet.";
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                message = "Phone has been disconnected from the power outlet";
                break;
            case MainActivity.ACTION_CUSTOM_BROADCAST:
                message = "Received a custom broadcast";
                break;
            default:
                message = "Unknown broadcast";
        }

        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}