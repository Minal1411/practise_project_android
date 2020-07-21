package com.example.asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    private static final String TAG="MainActivity";
     TextView textView;
     Button button;
     ProgressBar progressBar;
     ProgressBar progressIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            textView=findViewById(R.id.textView);
            button=findViewById(R.id.button);
            progressBar=findViewById(R.id.progressBar);
            progressIndicator=findViewById(R.id.progressindicator);
            textView.setText("");
            progressIndicator.setVisibility(View.INVISIBLE);

    }

    public void uploadTask(View view) {
        //Toast.makeText(this, "button Clicked", Toast.LENGTH_SHORT).show();
//        UploadTask uploadTask=new UploadTask();
//        uploadTask.execute();
        new UploadTask().execute( "This is the string passed");


    }
    class UploadTask extends AsyncTask<String,Void,String>{
        @Override
        protected void onPreExecute() {
            Log.d("dbharry", "onPreExecute: "+Thread.currentThread().getName());
            progressIndicator.setVisibility(View.VISIBLE);
            button.setEnabled(false);
            textView.setText("Uploading data.....");
        }

        @Override
        protected String doInBackground(String... string) {
            Log.d("dbharry", "doInBackground: String passed:"+string[0]);
            Log.d("dbharry", "doInBackground: Thread:" +Thread.currentThread().getName());
            for (int i=0;i<10;i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "finally the task is complete";
        }

        @Override
        protected void onPostExecute(String string) {
            Log.d("dbharry", "onPostExecute: "+Thread.currentThread().getName());
            textView.setText(string);
            progressIndicator.setVisibility(View.INVISIBLE);
            button.setEnabled(true);
        }
    }
}
