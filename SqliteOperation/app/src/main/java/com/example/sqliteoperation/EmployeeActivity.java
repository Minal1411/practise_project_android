package com.example.sqliteoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static com.example.sqliteoperation.MainActivity.DATABASE_NAME;

public class EmployeeActivity extends AppCompatActivity {

    List<Employee> employeeList;
    SQLiteDatabase mdatabase;
    ListView listView;
    EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView=(ListView)findViewById(R.id.listViewEmployees);
        employeeList=new ArrayList<>();
        mdatabase = openOrCreateDatabase(MainActivity.DATABASE_NAME, MODE_PRIVATE, null);
        loadEmployeesFromDatabase();
    }
    private void loadEmployeesFromDatabase(){
        String sql="SELECT * FROM employees";
        mdatabase.rawQuery(sql,null);
        Cursor cursor=mdatabase.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do {
                    employeeList.add(new Employee(
                            cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getDouble(4)
                    ));
            }while (cursor.moveToNext());
            cursor.close();
             adapter=new EmployeeAdapter(this,R.layout.list_layout_employees,employeeList);
                listView.setAdapter(adapter);

        }

    }

}
