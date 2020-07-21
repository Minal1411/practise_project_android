package com.example.kotlinlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var textview: TextView
    lateinit var addButton: Button
    lateinit var listview: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.edittext)
        listview = findViewById(R.id.listview)
        addButton = findViewById(R.id.addButton)

        var listData= arrayListOf<String>()

        //Populating the data in the list view
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listData)
        listview.adapter=adapter
        addButton.setOnClickListener(object: View.OnClickListener{

            override fun onClick( view: View? ) {

                var str=editText.text.toString()
                listData.add(str)
                adapter.notifyDataSetChanged()   //Notifies the ListView that the data has changed
            }

        }  )
    }
}
