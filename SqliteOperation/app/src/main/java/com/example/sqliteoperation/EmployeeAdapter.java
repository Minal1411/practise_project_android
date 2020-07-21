package com.example.sqliteoperation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {
    Context mctx;
    int layoutRes;
    List<Employee> employeeList;
    public EmployeeAdapter(Context mctx, int layoutRes, List<Employee> employeeList){
        super(mctx,layoutRes,employeeList);
        this.mctx=mctx;
        this.layoutRes=layoutRes;
        this.employeeList=employeeList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //for list of listlayout file
        LayoutInflater inflater=LayoutInflater.from(mctx);
        View view=inflater.inflate(layoutRes,null);
        TextView textViewName=view.findViewById(R.id.textViewName);
        TextView textViewDept=view.findViewById(R.id.textViewDepartment);
        TextView textViewSalary=view.findViewById(R.id.textViewSalary);
        TextView textViewJoinDate=view.findViewById(R.id.textViewJoiningDate);
        Employee employee=employeeList.get(position);
        textViewName.setText(employee.getName());
        textViewDept.setText(employee.getDept());
        textViewSalary.setText(String.valueOf(employee.getSalary()));
        textViewJoinDate.setText(employee.getJoiningdate());
        return view;
    }
}
