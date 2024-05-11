package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RoomView extends AppCompatActivity {

    ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> list=new ArrayList<>();
    private SearchView searchView;
    Button viewAvailableRoomsBtn;

    Roomdb mydbd;

    ArrayList<Integer> ridList = new ArrayList<>();
    ArrayList<String> cidList = new ArrayList<>();
    ArrayList<String> rtypeList = new ArrayList<>();
    ArrayList<String> rateList = new ArrayList<>();
    ArrayList<String> indateList = new ArrayList<>();
    ArrayList<String> outdateList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_view);

        viewAvailableRoomsBtn = findViewById(R.id.viewavailableRooms);

        mydbd = new Roomdb(this);
        searchView = findViewById(R.id.searchview);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                fileList(newText);
                return true;
            }
        });

        listView=(ListView)findViewById(R.id.listview_room);

        arrayAdapter=new ArrayAdapter<String>(this,R.layout.list_item,list);
        listView.setAdapter(arrayAdapter);

        viewAvailableRoomsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RoomView.this, ViewAvailableRooms.class);
                startActivity(i);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                final AlertDialog.Builder builder=new AlertDialog.Builder(RoomView.this);
                builder.setTitle("Alert!");
                builder.setMessage("Do you want to delete this entry ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mydbd.deleteRoom(ridList.get(i));
                        Toast.makeText(RoomView.this, "Room with Id "+ridList.get(i)+ " is Deleted!", Toast.LENGTH_SHORT).show();

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

        ArrayList<RoomModel> roomTableData = mydbd.fetchRoomDetails();

        for(int i=0; i<roomTableData.size(); i++)
        {
            ridList.add(roomTableData.get(i).getRmid());
            cidList.add(roomTableData.get(i).getRmcid());
            rtypeList.add(roomTableData.get(i).getRmtype());
            rateList.add(roomTableData.get(i).getRmrate());
            indateList.add(roomTableData.get(i).getRmindate());
            outdateList.add(roomTableData.get(i).getRmoutdate());
        }

        list.clear();
        for(int j=0; j< ridList.size(); j++)
        {
            list.add("Room Id: "+ridList.get(j)+"\n"+
                    "C Id: "+cidList.get(j)+"\n"+
                    "R Type: "+rtypeList.get(j)+"\n"+

                    "Rate: "+rateList.get(j)+"\n"+
                    "In Date: "+indateList.get(j)+"\n"+
                    "Out Date: "+outdateList.get(j));
        }
        arrayAdapter.notifyDataSetChanged();
    }

    private void fileList(String text) {
        List<ClipData.Item> filteredList = new ArrayList<>();

        arrayAdapter.notifyDataSetChanged();
    }




    @Override
    public void onBackPressed() {
        Intent i = new Intent(RoomView.this, ViewData.class);
        startActivity(i);
    }
}