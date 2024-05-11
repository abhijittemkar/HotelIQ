package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Staf extends AppCompatActivity {

    EditText ename, ephone, eadd, epost, esalary, eid;
    Button eaddbtn;
    employeedb emydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staf);

        ename = findViewById(R.id.empname);
        ephone = findViewById(R.id.empphone);
        eadd = findViewById(R.id.empadd);
        epost = findViewById(R.id.emppost);
        esalary = findViewById(R.id.empsalary);
        eid = findViewById(R.id.empid);
        eaddbtn = findViewById(R.id.empsave);

        emydb = new employeedb(this);
        eaddData();
    }

    public void eaddData() {


        eaddbtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String emname = ename.getText().toString();
                String emphone = ephone.getText().toString();
                String emadd = eadd.getText().toString();
                String empost = epost.getText().toString();
                String emsalary = esalary.getText().toString();
                String emid = eid.getText().toString();

                boolean insertData = emydb.eaddData(emid, emname, emphone, emadd, empost, emsalary);
                if (insertData == true) {
                    Toast.makeText(Staf.this, "Data successfully inserted", Toast.LENGTH_LONG).show();
                ename.setText("");
                ephone.setText("");
                eadd.setText("");
                ephone.setText("");
                epost.setText("");
                esalary.setText("");
                eid.setText("");


                } else {
                    Toast.makeText(Staf.this, "something went wrong", Toast.LENGTH_LONG).show();


                }
            }
        });
    }
}