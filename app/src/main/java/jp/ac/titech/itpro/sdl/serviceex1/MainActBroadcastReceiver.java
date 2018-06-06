package jp.ac.titech.itpro.sdl.serviceex1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        String message = bundle.getString("message");

        Toast.makeText(
                context,
                "RECEIVED!! " + message,
                Toast.LENGTH_LONG).show();
    }

}
