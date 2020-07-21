package com.example.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyHelper helper = new MyHelper(this);
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("PRICE",280.00);
        database.update("PRODUCTS",values,"_id=?",new String[]{"1"});
        database.delete("PRODUCTS","_id=?",new String[]{"1"});

        Cursor cursor = database.rawQuery("SELECT NAME,PRICE FROM PRODUCTS", new String[]{});
        if (cursor != null) {
            cursor.moveToFirst();
        }
        StringBuilder builder = new StringBuilder();
        do {
            String name = cursor.getString(0);
            double price = cursor.getDouble(1);
            builder.append("NAME - "+ name + "PRICE - "+ price);
        } while (cursor.moveToNext());
        TextView textView = (TextView) findViewById(R.id.txtData);
        textView.setText(builder.toString());
    }
}
