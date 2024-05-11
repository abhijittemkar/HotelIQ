package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateEmployee extends AppCompatActivity {

    EditText EmployeeIdEt,
            EmployeeNameEt,
            EmployeePhoneEt,
            EmployeeAddressEt,
            EmployeePostEt,
            EmployeeSalaryEt;

    Button EmployeeCheckIdBtn, EmployeeUpdateBtn;

    employeedb mydbd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_employee);

        EmployeeIdEt = findViewById(R.id.employeeid);
        EmployeeNameEt = findViewById(R.id.employeename);
        EmployeePhoneEt = findViewById(R.id.employeephone);
        EmployeeAddressEt = findViewById(R.id.employeeaddress);
        EmployeePostEt = findViewById(R.id.employeepost);
        EmployeeSalaryEt = findViewById(R.id.employeesalary);

        EmployeeCheckIdBtn = findViewById(R.id.checkEmployeeIdBtn);
        EmployeeUpdateBtn = findViewById(R.id.employeeUpdateBtn);

        EmployeeNameEt.setVisibility(View.INVISIBLE);
        EmployeePhoneEt.setVisibility(View.INVISIBLE);
        EmployeeAddressEt.setVisibility(View.INVISIBLE);
        EmployeePostEt.setVisibility(View.INVISIBLE);
        EmployeeSalaryEt.setVisibility(View.INVISIBLE);

        EmployeeUpdateBtn.setVisibility(View.INVISIBLE);

        mydbd = new employeedb(this);

        EmployeeCheckIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(EmployeeIdEt.getText().toString().equals(""))
                {
                    Toast.makeText(UpdateEmployee.this, "Please enter id to update the details", Toast.LENGTH_SHORT).show();
                }
                else if(mydbd.checkEmployeeId(Integer.parseInt(EmployeeIdEt.getText().toString())))
                {
                    EmployeeNameEt.setVisibility(View.VISIBLE);
                    EmployeePhoneEt.setVisibility(View.VISIBLE);
                    EmployeeAddressEt.setVisibility(View.VISIBLE);
                    EmployeePostEt.setVisibility(View.VISIBLE);
                    EmployeeSalaryEt.setVisibility(View.VISIBLE);

                    EmployeeCheckIdBtn.setVisibility(View.INVISIBLE);
                    EmployeeUpdateBtn.setVisibility(View.VISIBLE);
                }
                else
                {
                    Toast.makeText(UpdateEmployee.this, "The Employee Id that you entered is not exists in our records ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        EmployeeUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(EmployeeNameEt.getText().toString().equals(""))
                {
                    Toast.makeText(UpdateEmployee.this, "Please enter employee name to update", Toast.LENGTH_SHORT).show();
                }
                else if(EmployeePhoneEt.getText().toString().equals(""))
                {
                    Toast.makeText(UpdateEmployee.this, "Please enter employee phone to update", Toast.LENGTH_SHORT).show();
                }
                else if(EmployeeAddressEt.getText().toString().equals(""))
                {
                    Toast.makeText(UpdateEmployee.this, "Please enter employee address to update", Toast.LENGTH_SHORT).show();
                }
                else if(EmployeePostEt.getText().toString().equals(""))
                {
                    Toast.makeText(UpdateEmployee.this, "Please enter employee post to update", Toast.LENGTH_SHORT).show();
                }
                else if(EmployeeSalaryEt.getText().toString().equals(""))
                {
                    Toast.makeText(UpdateEmployee.this, "Please enter employee salary to update", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    EmployeeModel employeeModel = new EmployeeModel();
                    employeeModel.setEmname(EmployeeNameEt.getText().toString());
                    employeeModel.setEmphone(EmployeePhoneEt.getText().toString());
                    employeeModel.setEmadd(EmployeeAddressEt.getText().toString());
                    employeeModel.setEmpost(EmployeePostEt.getText().toString());
                    employeeModel.setEmsalary(EmployeeSalaryEt.getText().toString());

                    employeeModel.setEmid(Integer.parseInt(EmployeeIdEt.getText().toString()));

                    mydbd.updateEmployee(employeeModel);

                    Toast.makeText(UpdateEmployee.this, "Details Updated!", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(UpdateEmployee.this, EmployeeView.class);
                    startActivity(i);

                }
            }
        });
    }
}