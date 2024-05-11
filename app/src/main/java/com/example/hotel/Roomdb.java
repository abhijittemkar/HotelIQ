package com.example.hotel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Roomdb extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "RoomMst.db";

    // employee table


    public static final String rTab = "roomdet";

    private static final String rCOL0 = "roomid";
    private static final String rCOL1 = "cid";
    private static final String rCOL2 = "rtype";
    private static final String rCOL3 = "rate";
    private static final String rCOL4 = "indate";
    private static final String rCOL5 = "outdate";


    public Roomdb(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        String query2 = "CREATE TABLE " + rTab + " ("
                + rCOL0 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + rCOL1 + " TEXT,"
                + rCOL2 + " TEXT,"
                + rCOL3 + " TEXT,"
                + rCOL4 + " TEXT,"
                + rCOL5 + " TEXT)";
        db.execSQL(query2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + rTab);
        onCreate(db);
    }

    public boolean RaddData(String rid, String cid, String rtype, String rate, String indate, String outdate) {


        SQLiteDatabase rdb = this.getWritableDatabase();
        ContentValues RoomValue = new ContentValues();
        RoomValue.put(rCOL0, rid);
        RoomValue.put(rCOL1, cid);
        RoomValue.put(rCOL2, rtype);
        RoomValue.put(rCOL3, rate);
        RoomValue.put(rCOL4, indate);
        RoomValue.put(rCOL5, outdate);

        long res = rdb.insert(rTab, null, RoomValue);
        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<RoomModel> fetchRoomDetails(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+rTab, null);

        ArrayList<RoomModel> roomArray = new ArrayList<>();

        while (cursor.moveToNext())
        {
            RoomModel roomModel = new RoomModel();

            roomModel.setRmid(cursor.getInt(0));
            roomModel.setRmcid(cursor.getString(1));
            roomModel.setRmtype(cursor.getString(2));
            roomModel.setRmrate(cursor.getString(3));
            roomModel.setRmindate(cursor.getString(4));
            roomModel.setRmoutdate(cursor.getString(5));

            roomArray.add(roomModel);
        }

        return roomArray;
    }
    public void deleteRoom(int id)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(rTab,rCOL0+ " = ? ", new String[]{String.valueOf(id)});
    }

    public void updateRoom(RoomModel roomModel){


        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(rCOL1, roomModel.getRmcid());
        contentValues.put(rCOL2, roomModel.getRmtype());
        contentValues.put(rCOL3, roomModel.getRmrate());
        contentValues.put(rCOL4, roomModel.getRmindate());
        contentValues.put(rCOL5, roomModel.getRmoutdate());

        database.update(rTab, contentValues, rCOL0 +" = "+roomModel.getRmid(),null);

    }

    public boolean checkRoomId(int id)
    {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from "+rTab, null);

        boolean isExist = false;

        while (cursor.moveToNext()){
            if(cursor.getInt(0) == id)
            {
                isExist = true;
            }
        }
        return isExist;
    }





}
