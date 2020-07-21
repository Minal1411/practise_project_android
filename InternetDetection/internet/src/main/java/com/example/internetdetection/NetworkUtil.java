package com.example.internetdetection;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {
    public static  int color;
    public static String getConnectivityStatusString(Context context) {

        String status = null;
        ConnectivityManager cm = (ConnectivityManager)           context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                status = "Good! Connected to Internet";
                color = Color.WHITE;
                return status;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                status = "Mobile data enabled in app";
                return status;
            }
        } else {
            status = "Sorry! Not connected to internet";
            color = Color.RED;
            return status;
        }
        return status;
    }
}

