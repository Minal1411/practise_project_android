package com.example.data_binding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.data_binding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
       ActivityMainBinding activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
//ActivityMainBinding activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
//setContentView(activityMainBinding.getRoot());
        //activityMainBinding.setMyVariable("Hello Databinding..");
        User user=new User("Yours Truly",18,false,"https://i.picsum.photos/id/237/200/200.jpg");
        activityMainBinding.setUser(user);

    }
}
