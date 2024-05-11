package com.example.hotel;


import static com.example.hotel.MyDbHandler.Tab;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;


public class Home extends AppCompatActivity{
        //variables
        EditText name,phone,add,city,postal,zender,mail,adhar,id;

        int ide=0;
        Button addbtn,updatebtn;
        MyDbHandler mydb;
                SQLiteDatabase sqLiteDatabase;

@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        name=findViewById(R.id.cname);
        phone=findViewById(R.id.cphone);
        add=findViewById(R.id.cadd);
        city=findViewById(R.id.ccity);
        postal=findViewById(R.id.cpost);
        zender=findViewById(R.id.czen);
        mail=findViewById(R.id.cmail);
        adhar=findViewById(R.id.cadr);
        id=findViewById(R.id.cid);
        addbtn=findViewById(R.id.cusave);

        mydb=new MyDbHandler(this);
        addData();

        }






        // save data (add button)
public void addData()

        {


        addbtn.setOnClickListener(new View.OnClickListener(){


@Override
public void onClick(View v){

        String cuname=name.getText().toString();
        String cuphone=phone.getText().toString();
        String cuadd=add.getText().toString();
        String cucity=city.getText().toString();
        String cupost=postal.getText().toString();
        String cuzender=zender.getText().toString();
        String cumail=mail.getText().toString();
        String cuadhar=adhar.getText().toString();
        String cuid=id.getText().toString();
        boolean insertData=mydb.addData(cuid,cuname,cuphone,cucity,cupost,cuadd,cuzender,cumail,cuadhar);
        if(insertData==true){
        Toast.makeText(Home.this,"Data successfully inserted",Toast.LENGTH_LONG).show();
        name.setText("");
        phone.setText("");
        add.setText("");
        city.setText("");
        postal.setText("");
        zender.setText("");
        mail.setText("");
        adhar.setText("");
        id.setText("");

        }else{
        Toast.makeText(Home.this,"something went wrong",Toast.LENGTH_LONG).show();


        }
        }
        });

        }


}

