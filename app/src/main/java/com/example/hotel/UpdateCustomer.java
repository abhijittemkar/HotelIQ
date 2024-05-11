package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateCustomer extends AppCompatActivity {

    EditText CustomerIdEt,
            CustomerNameEt,
            CustomerPhoneEt,
            CustomerAddressEt,
            CustomerCityEt,
            CustomerPostalCodeEt,
            CustomerGenderEt,
            CustomerEmailEt,
            CustomerAadhaarEt;

    Button CustomerUpdateButton, CheckCustomerId;

    MyDbHandler mydbd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_customer);

        CustomerIdEt = findViewById(R.id.customerid);
        CustomerNameEt = findViewById(R.id.customername);
        CustomerPhoneEt = findViewById(R.id.customerphone);
        CustomerAddressEt = findViewById(R.id.customeraddress);
        CustomerCityEt = findViewById(R.id.customercity);
        CustomerPostalCodeEt = findViewById(R.id.customerpostalcode);
        CustomerGenderEt = findViewById(R.id.customergender);
        CustomerEmailEt = findViewById(R.id.customermail);
        CustomerAadhaarEt = findViewById(R.id.customeraadhaar);

        CustomerUpdateButton = findViewById(R.id.customerUpdateBtn);
        CheckCustomerId = findViewById(R.id.checkCustomerIdBtn);

        CustomerNameEt.setVisibility(View.INVISIBLE);
        CustomerPhoneEt.setVisibility(View.INVISIBLE);
        CustomerAddressEt.setVisibility(View.INVISIBLE);
        CustomerCityEt.setVisibility(View.INVISIBLE);
        CustomerPostalCodeEt.setVisibility(View.INVISIBLE);
        CustomerGenderEt.setVisibility(View.INVISIBLE);
        CustomerEmailEt.setVisibility(View.INVISIBLE);
        CustomerAadhaarEt.setVisibility(View.INVISIBLE);

        CustomerUpdateButton.setVisibility(View.INVISIBLE);

        mydbd = new MyDbHandler(this);

        CheckCustomerId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CustomerIdEt.getText().toString().equals(""))
                {
                    Toast.makeText(UpdateCustomer.this, "Please enter id to update the details", Toast.LENGTH_SHORT).show();
                }
                else if(mydbd.checkCustomerId(Integer.parseInt(CustomerIdEt.getText().toString())))
                {
                    CustomerNameEt.setVisibility(View.VISIBLE);
                    CustomerPhoneEt.setVisibility(View.VISIBLE);
                    CustomerAddressEt.setVisibility(View.VISIBLE);
                    CustomerCityEt.setVisibility(View.VISIBLE);
                    CustomerPostalCodeEt.setVisibility(View.VISIBLE);
                    CustomerGenderEt.setVisibility(View.VISIBLE);
                    CustomerEmailEt.setVisibility(View.VISIBLE);
                    CustomerAadhaarEt.setVisibility(View.VISIBLE);

                    CustomerUpdateButton.setVisibility(View.VISIBLE);

                    CheckCustomerId.setVisibility(View.INVISIBLE);
                }
                else
                {
                    Toast.makeText(UpdateCustomer.this, "The Customer Id that you entered is not exists in our records ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        CustomerUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(CustomerNameEt.getText().toString().equals(""))
                {
                    Toast.makeText(UpdateCustomer.this, "Please enter name to update", Toast.LENGTH_SHORT).show();
                }
                else if(CustomerPhoneEt.getText().toString().equals(""))
                {
                    Toast.makeText(UpdateCustomer.this, "Please enter phone to update", Toast.LENGTH_SHORT).show();
                }
                else if(CustomerAddressEt.getText().toString().equals(""))
                {
                    Toast.makeText(UpdateCustomer.this, "Please enter address to update", Toast.LENGTH_SHORT).show();
                }
                else if(CustomerCityEt.getText().toString().equals(""))
                {
                    Toast.makeText(UpdateCustomer.this, "Please enter city to update", Toast.LENGTH_SHORT).show();
                }
                else if(CustomerPostalCodeEt.getText().toString().equals(""))
                {
                    Toast.makeText(UpdateCustomer.this, "Please enter postal code to update", Toast.LENGTH_SHORT).show();
                }
                else if(CustomerGenderEt.getText().toString().equals(""))
                {
                    Toast.makeText(UpdateCustomer.this, "Please enter gender to update", Toast.LENGTH_SHORT).show();
                }
                else if(CustomerEmailEt.getText().toString().equals(""))
                {
                    Toast.makeText(UpdateCustomer.this, "Please enter email to update", Toast.LENGTH_SHORT).show();
                }
                else if(CustomerAadhaarEt.getText().toString().equals(""))
                {
                    Toast.makeText(UpdateCustomer.this, "Please enter aadhaar number to update", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Model model = new Model();
                    model.setName(CustomerNameEt.getText().toString());
                    model.setPhone(CustomerPhoneEt.getText().toString());
                    model.setAdd(CustomerAddressEt.getText().toString());
                    model.setCity(CustomerCityEt.getText().toString());
                    model.setPostal(CustomerPostalCodeEt.getText().toString());
                    model.setZender(CustomerGenderEt.getText().toString());
                    model.setMail(CustomerEmailEt.getText().toString());
                    model.setAdhar(CustomerAadhaarEt.getText().toString());
                    model.setId(Integer.parseInt(CustomerIdEt.getText().toString()));

                    mydbd.updateCustomer(model);

                    Toast.makeText(UpdateCustomer.this, "Details Updated!", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(UpdateCustomer.this, CustomerView.class);
                    startActivity(i);

                }
            }
        });
    }
}