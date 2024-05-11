package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class UpdateRoom extends AppCompatActivity {


    EditText RoomIdEt,
            RoomCIdEt,
            RoomTypeEt,
            RoomRateEt,
            RoomInDateEt,
            RoomOutDateEt;

    Button RoomCheckIdBtn, RoomUpdateBtn;

    Roomdb mydbd;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_room);


        RoomIdEt = findViewById(R.id.roomid);
        RoomCIdEt = findViewById(R.id.roomcid);
        RoomTypeEt = findViewById(R.id.roomtype);
        RoomRateEt = findViewById(R.id.roomrate);
        RoomInDateEt = findViewById(R.id.roomindate);
        RoomOutDateEt = findViewById(R.id.roomoutdate);

        RoomCheckIdBtn = findViewById(R.id.checkRoomIdBtn);
        RoomUpdateBtn = findViewById(R.id.roomUpdateBtn);

        RoomCIdEt.setVisibility(View.INVISIBLE);
        RoomTypeEt.setVisibility(View.INVISIBLE);
        RoomRateEt.setVisibility(View.INVISIBLE);
        RoomInDateEt.setVisibility(View.INVISIBLE);
        RoomOutDateEt.setVisibility(View.INVISIBLE);

        RoomUpdateBtn.setVisibility(View.VISIBLE);

        mydbd = new Roomdb(this);

        RoomCheckIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (RoomCheckIdBtn.getText().toString().equals("")) {
                    Toast.makeText(UpdateRoom.this, "Please enter id to update the details", Toast.LENGTH_SHORT).show();
                } else if (mydbd.checkRoomId(Integer.parseInt(RoomIdEt.getText().toString()))) {
                    RoomCIdEt.setVisibility(View.VISIBLE);
                    RoomTypeEt.setVisibility(View.VISIBLE);
                    RoomRateEt.setVisibility(View.VISIBLE);
                    RoomInDateEt.setVisibility(View.VISIBLE);
                    RoomOutDateEt.setVisibility(View.VISIBLE);

                    RoomCheckIdBtn.setVisibility(View.INVISIBLE);
                    RoomUpdateBtn.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(UpdateRoom.this, "The Room Id that you entered is not exists in our records ", Toast.LENGTH_SHORT).show();
                }
            }
        });


        RoomUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (RoomCIdEt.getText().toString().equals("")) {
                    Toast.makeText(UpdateRoom.this, "Please enter CId to update", Toast.LENGTH_SHORT).show();
                } else if (RoomTypeEt.getText().toString().equals("")) {
                    Toast.makeText(UpdateRoom.this, "Please enter room type to update", Toast.LENGTH_SHORT).show();
                } else if (RoomRateEt.getText().toString().equals("")) {
                    Toast.makeText(UpdateRoom.this, "Please enter room rate to update", Toast.LENGTH_SHORT).show();
                } else if (RoomInDateEt.getText().toString().equals("")) {
                    Toast.makeText(UpdateRoom.this, "Please enter room in date to update", Toast.LENGTH_SHORT).show();
                } else if (RoomOutDateEt.getText().toString().equals("")) {
                    Toast.makeText(UpdateRoom.this, "Please enter room out date to update", Toast.LENGTH_SHORT).show();
                } else {
                    RoomModel roomModel = new RoomModel();
                    roomModel.setRmcid(RoomCIdEt.getText().toString());
                    roomModel.setRmtype(RoomTypeEt.getText().toString());
                    roomModel.setRmrate(RoomRateEt.getText().toString());
                    roomModel.setRmindate(RoomInDateEt.getText().toString());
                    roomModel.setRmoutdate(RoomOutDateEt.getText().toString());

                    roomModel.setRmid(Integer.parseInt(RoomIdEt.getText().toString()));

                    mydbd.updateRoom(roomModel);

                    Toast.makeText(UpdateRoom.this, "Details Updated!", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(UpdateRoom.this, RoomView.class);
                    startActivity(i);

                }
            }

        });
    }
}