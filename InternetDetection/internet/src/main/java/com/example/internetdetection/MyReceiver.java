package com.example.internetdetection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import static com.example.internetdetection.MainActivity.relativeLayout;

public class MyReceiver extends BroadcastReceiver {

public static String states;
    @Override
    public void onReceive(Context context, Intent intent) {
         states = NetworkUtil.getConnectivityStatusString(context);
        if (states.isEmpty()) {
            states = "No Internet Connection in app";
        }
        //Toast.makeText(context, states, Toast.LENGTH_SHORT).show();
        Snackbar snackbar=Snackbar.make(relativeLayout,states, Snackbar.LENGTH_LONG);
//                .setAction("RETRY", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                    }
//                });
//        // Changing message text color
//        View snackBarView = snackbar.getView();
//        TextView textView = snackBarView.findViewById(R.id.snackbar_text);
//        textView.setTextColor(Color.GREEN);
        snackbar.show();

    }
}
