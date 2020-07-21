package com.example.myfirstkotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    companion object{
        const val KEY_NAME="name"
    }


    //we have all the three objects as below
    lateinit var editTextName: EditText
    lateinit var buttonClickMe: Button
    lateinit var buttonIntroduce: Button
    lateinit var textViewMessage: TextView
    lateinit var buttonGoToNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextName = findViewById(R.id.editTextName)
        buttonClickMe = findViewById(R.id.buttonClickMe)
        buttonIntroduce = findViewById(R.id.introduce)
        buttonGoToNext=findViewById(R.id.gotonext)
        buttonIntroduce.setOnClickListener{
            var name = editTextName.text
            textViewMessage.text = "Hello $name"
        }
        textViewMessage = findViewById(R.id.textViewMessage)
        buttonClickMe.setOnClickListener {
            var name = editTextName.text
            textViewMessage.text = "Hello $name,I am your friend android"
        }
        buttonGoToNext.setOnClickListener {
            val intent: Intent=Intent(applicationContext,ResultActivity::class.java)  //calling constructor of intent
            val name:String=editTextName.text.toString()
            val  hero=Hero("Spiderman","Peter parker")
            intent.putExtra(KEY_NAME,hero)
            startActivity(intent)

        }
    }


}


