package com.example.hotel;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    public void GoToBase(View view) {
        EditText getUser = findViewById(R.id.txtUser);
        EditText getPass = findViewById(R.id.txtPass);
        String username = getUser.getText().toString().trim();
        String userPass = getPass.getText().toString().trim();


        if (username.equals("HOTELIQ") && userPass.equals("12345")) {
            Intent intent = new Intent(this, Base.class);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Enter Valid Username and Password", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }


}
