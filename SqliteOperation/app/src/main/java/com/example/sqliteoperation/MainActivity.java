package com.example.sqliteoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String DATABASE_NAME = "mydatabase";
    // we can store data in sqlite database
    SQLiteDatabase mdatabase;
    //we have all the views
    EditText editTextName, editTextSalary;
    Spinner spinnerDept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        createTable();
        //mow initialize all the views
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextSalary = (EditText) findViewById(R.id.editTextSalary);
        spinnerDept = (Spinner) findViewById(R.id.SpinnerDepartment);
        findViewById(R.id.buttonAddEmplopyee).setOnClickListener(this);
        findViewById(R.id.textViewViewEmployees).setOnClickListener(this);
    }

    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS employees (\n" +
                "    id INTEGER NOT NULL CONSTRAINT employees_pk PRIMARY KEY AUTOINCREMENT,\n" +
                "    name varchar(200) NOT NULL,\n" +
                "    department varchar(200) NOT NULL,\n" +
                "    joiningdate datetime NOT NULL,\n" +
                "    salary double NOT NULL\n" +
                ");";
        //to execute this query
        mdatabase.execSQL(sql);
    }

    private void addEmployee() {
        String name = editTextName.getText().toString().trim();
        String salary = editTextSalary.getText().toString().trim();
        String dept = spinnerDept.getSelectedItem().toString();
        if (name.isEmpty()) {
            editTextName.setError("name can't be empty");
            editTextName.requestFocus();
            return;
        }
        if (salary.isEmpty()) {
            editTextSalary.setError("salary can't be empty");
            editTextSalary.requestFocus();
            return;
        }
        //getting the current time for joining date
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String joiningDate = sdf.format(cal.getTime());
            //to insert the value in the database table using sql we do
        String  sql="INSERT INTO employees(name, department, joiningdate, salary)" +
                "VALUES(?, ?, ?, ?)";
        mdatabase.execSQL(sql, new String[]{name, dept,joiningDate , salary});
        Toast.makeText(this, "Employee Added", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAddEmplopyee:
                addEmployee();
                break;
            case R.id.textViewViewEmployees:
                startActivity(new Intent(this,EmployeeActivity.class));
                break;

        }
    }
}
