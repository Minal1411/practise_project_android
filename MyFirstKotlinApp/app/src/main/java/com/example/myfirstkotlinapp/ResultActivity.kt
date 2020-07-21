package com.example.myfirstkotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    lateinit var textviewName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        textviewName=findViewById(R.id.textViewName)
       val hero=intent.getSerializableExtra(MainActivity.KEY_NAME)as Hero
        textviewName.text="Name is" + hero.name+"and real name is "+ hero.realName
    }
}
