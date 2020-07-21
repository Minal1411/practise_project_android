package com.example.networkconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.bottom);
    }
    public void buttonclicked(View view) {
        if (!isConnected(this)){
            showCustomDialog();

     }
    }

    private boolean isConnected(MainActivity mainActivity) {
        ConnectivityManager manager=(ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork=manager.getActiveNetworkInfo();
        if (null!=activeNetwork){
            if (activeNetwork.getType()==ConnectivityManager.TYPE_WIFI){
                Toast.makeText(this, "wifi Enabled", Toast.LENGTH_SHORT).show();
            }
            else if (activeNetwork.getType()==ConnectivityManager.TYPE_MOBILE){
                Toast.makeText(this, "Data network enabled", Toast.LENGTH_SHORT).show();
            }

        }
        else{
            Toast.makeText(this, "No internet Connection", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
    private void showCustomDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Please connect to the internet to proceed further")
                .setCancelable(false)
                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(),RetailerStartUpScreen.class));
                        finish();
                    }
                });
    }


}
