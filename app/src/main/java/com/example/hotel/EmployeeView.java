package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class EmployeeView extends AppCompatActivity {

    ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> list=new ArrayList<>();

    employeedb mydbd;

    ArrayList<Integer> emidList = new ArrayList<>();
    ArrayList<String> emnameList = new ArrayList<>();
    ArrayList<String> emphoneList = new ArrayList<>();
    ArrayList<String> emaddList = new ArrayList<>();
    ArrayList<String> empostList = new ArrayList<>();
    ArrayList<String> emsalaryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_view);

        mydbd = new employeedb(this);

        listView=(ListView)findViewById(R.id.listview_employee);

        arrayAdapter=new ArrayAdapter<String>(this,R.layout.list_item,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                final AlertDialog.Builder builder=new AlertDialog.Builder(EmployeeView.this);
                builder.setTitle("Alert!");
                builder.setMessage("Do you want to delete this entry ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mydbd.deleteEmployee(emidList.get(i));
                        Toast.makeText(EmployeeView.this, "Employee with Id "+emidList.get(i)+ " is Deleted!", Toast.LENGTH_SHORT).show();

                        list.remove(i);
                        arrayAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                builder.show();

                return false;
            }
        });

        ArrayList<EmployeeModel> employeeTableData = mydbd.fetchEmployeeDetails();

        for(int i=0; i<employeeTableData.size(); i++)
        {
            emidList.add(employeeTableData.get(i).getEmid());
            emnameList.add(employeeTableData.get(i).getEmname());
            emphoneList.add(employeeTableData.get(i).getEmphone());
            emaddList.add(employeeTableData.get(i).getEmadd());
            empostList.add(employeeTableData.get(i).getEmpost());
            emsalaryList.add(employeeTableData.get(i).getEmsalary());
        }

        list.clear();
        for(int j=0; j< emidList.size(); j++)
        {
            list.add("E Id: "+emidList.get(j)+"\n"+
                    "Name: "+emnameList.get(j)+"\n"+
                    "Phone: "+emphoneList.get(j)+"\n"+
                    "Address: "+emaddList.get(j)+"\n"+
                    "Post: "+empostList.get(j)+"\n"+
                    "Salary: "+emsalaryList.get(j));
        }
        arrayAdapter.notifyDataSetChanged();
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(EmployeeView.this, ViewData.class);
        startActivity(i);
    }
}