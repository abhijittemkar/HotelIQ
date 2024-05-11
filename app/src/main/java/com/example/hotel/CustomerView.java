package com.example.hotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomerView extends AppCompatActivity {

    ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> list=new ArrayList<>();

    MyDbHandler mydbd;

    ArrayList<Integer> ideList = new ArrayList<>();
    ArrayList<String> nameList = new ArrayList<>();
    ArrayList<String> phoneList = new ArrayList<>();
    ArrayList<String> addList = new ArrayList<>();
    ArrayList<String> cityList = new ArrayList<>();
    ArrayList<String> postalList = new ArrayList<>();
    ArrayList<String> zenderList = new ArrayList<>();
    ArrayList<String> mailList = new ArrayList<>();
    ArrayList<String> adharList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view);

        mydbd = new MyDbHandler(this);

        listView=(ListView)findViewById(R.id.listview);

        arrayAdapter=new ArrayAdapter<String>(this,R.layout.list_item,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                final AlertDialog.Builder builder=new AlertDialog.Builder(CustomerView.this);
                builder.setTitle("Alert!");
                builder.setMessage("Do you want to delete this entry ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mydbd.deleteCustomer(ideList.get(i));
                        Toast.makeText(CustomerView.this, "Customer with Id "+ideList.get(i)+ " is Deleted!", Toast.LENGTH_SHORT).show();

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


        ArrayList<Model> customerTableData = mydbd.fetchCustomerDetails();

        for(int i=0; i<customerTableData.size(); i++)
        {
            ideList.add(customerTableData.get(i).getId());
            nameList.add(customerTableData.get(i).getName());
            phoneList.add(customerTableData.get(i).getPhone());
            addList.add(customerTableData.get(i).getAdd());
            cityList.add(customerTableData.get(i).getCity());
            postalList.add(customerTableData.get(i).getPostal());
            zenderList.add(customerTableData.get(i).getZender());
            mailList.add(customerTableData.get(i).getMail());
            adharList.add(customerTableData.get(i).getAdhar());
        }

        list.clear();
        for(int j=0; j< ideList.size(); j++)
        {
            list.add("Name: "+nameList.get(j)+"\n"+
                    "Phone: "+phoneList.get(j)+"\n"+
                    "Address: "+addList.get(j)+"\n"+
                    "City: "+cityList.get(j)+"\n"+
                    "Postal Code: "+postalList.get(j)+"\n"+
                    "Gender: "+zenderList.get(j)+"\n"+
                    "Email: "+mailList.get(j)+"\n"+
                    "Aadhaar Number: "+adharList.get(j)+"\n"+
                    "Customer Id: "+ideList.get(j));
        }
        arrayAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(CustomerView.this, ViewData.class);
        startActivity(i);
    }
}