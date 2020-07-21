package com.example.internetdetection;

import androidx.appcompat.app.AppCompatActivity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.google.android.material.snackbar.Snackbar;
import static com.example.internetdetection.MyReceiver.states;


public class MainActivity extends AppCompatActivity {
    private BroadcastReceiver MyReceiver = null;
    public static RelativeLayout relativeLayout;
    public static Snackbar snackbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout=findViewById(R.id.re);
        MyReceiver = new MyReceiver();
                broadcastIntent();

    }
    public void broadcastIntent() {
        registerReceiver(MyReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }
    @Override
    protected void onDestroy() {
        unregisterReceiver(MyReceiver);
        super.onDestroy();
    }


//   public void snack(View view) {
//        Snackbar snackbar=Snackbar.make(relativeLayout,states,Snackbar.LENGTH_INDEFINITE);
//        snackbar.show();
//    }
}

