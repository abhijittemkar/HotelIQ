package com.example.hotel;


import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.hotel.ui.home.HomeFragment;

import java.util.ArrayList;

public class ViewData extends AppCompatActivity {

    Button viewcustomer ,viewemp ,viewroom, updateCustomer, updateRoom, updateEmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        viewcustomer = findViewById(R.id.viewcu);
        viewemp = findViewById(R.id.viewEmp);
        viewroom = findViewById(R.id.viewRoom);

        updateCustomer = findViewById(R.id.updatecu);
        updateRoom = findViewById(R.id.updateRoom);
        updateEmp = findViewById(R.id.updateEmp);

        updateCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ViewData.this, UpdateCustomer.class);
                startActivity(i);
            }
        });
        updateRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ViewData.this, UpdateRoom.class);
                startActivity(i);
            }
        });
        updateEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ViewData.this, UpdateEmployee.class);
                startActivity(i);
            }
        });

        viewcustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ViewData.this, CustomerView.class);
                startActivity(i);
            }
        });

        viewemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ViewData.this, EmployeeView.class);
                startActivity(i);
            }
        });

        viewroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ViewData.this, RoomView.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(ViewData.this, Base.class);
        startActivity(i);
    }
}

