package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class RoomDetails extends AppCompatActivity {
    //variables
    EditText rmid, rmcid, rmtype, rmrate, rmindate, rmoutdate;
    Button Raddbtn;
    Roomdb rmydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_details);

        rmid = findViewById(R.id.Rid);
        rmcid = findViewById(R.id.RCid);
        rmtype = findViewById(R.id.RType);
        rmrate = findViewById(R.id.Rate);
        rmindate = findViewById(R.id.Rindate);
        rmoutdate = findViewById(R.id.Routdate);

        Raddbtn = findViewById(R.id.Radd);
        rmydb = new Roomdb(this);
        RaddData();
    }



    // save data (add button)
    public void RaddData()

    {


        Raddbtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String rid = rmid.getText().toString();
                String cid = rmcid.getText().toString();
                String rtype = rmtype.getText().toString();
                String rate= rmrate.getText().toString();
                String indate= rmindate.getText().toString();
                String outdate = rmoutdate.getText().toString();

                boolean insert =rmydb.RaddData( rid, cid,rtype, rate, indate,outdate);
                if(insert==true){
                    Toast.makeText(RoomDetails.this,"Data successfully inserted",Toast.LENGTH_LONG).show();
               rmid.setText("");
               rmcid.setText("");
               rmrate.setText("");
               rmtype.setText("");
               rmindate.setText("");
               rmoutdate.setText("");
                }

                else {
                    Toast.makeText(RoomDetails.this, "something went wrong", Toast.LENGTH_LONG).show();


                }
            }
        });




    }

}


