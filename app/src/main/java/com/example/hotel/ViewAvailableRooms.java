package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewAvailableRooms extends AppCompatActivity {

    Roomdb mydbd;

    ArrayList<String> rtypeList = new ArrayList<>();
    ArrayList<String> roomsList = new ArrayList<>();

    Button singleRoom, doubleRoom, deluxRoom, totalRoom;

    int singleRoomCount=0, doubleRoomCount = 0, deluxRoomCount = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_available_rooms);

        mydbd = new Roomdb(this);

        singleRoom = findViewById(R.id.singleroomNumber);
        doubleRoom = findViewById(R.id.doubleroomNumber);
        deluxRoom = findViewById(R.id.deluxroomNumber);
        totalRoom = findViewById(R.id.totalroomNumber);



        ArrayList<RoomModel> roomTableData = mydbd.fetchRoomDetails();

        for(int i=0; i<roomTableData.size(); i++)
        {
            rtypeList.add(roomTableData.get(i).getRmtype());
        }

        roomsList.clear();
        for(int j=0; j< rtypeList.size(); j++)
        {
            roomsList.add(rtypeList.get(j));
        }

        for (int k=0; k<roomsList.size(); k++)
        {
            if(roomsList.get(k).equals("single"))
            {
                singleRoomCount++;
            }
            else if(roomsList.get(k).equals("double"))
            {
                doubleRoomCount++;
            }
            else if(roomsList.get(k).equals("delux"))
            {
                deluxRoomCount++;
            }
        }

        totalRoom.setText(String.valueOf(roomsList.size()));
        singleRoom.setText(String.valueOf(singleRoomCount));
        doubleRoom.setText(String.valueOf(doubleRoomCount));
        deluxRoom.setText(String.valueOf(deluxRoomCount));

        Toast.makeText(this, "RoomList: "+roomsList, Toast.LENGTH_SHORT).show();
    }
}