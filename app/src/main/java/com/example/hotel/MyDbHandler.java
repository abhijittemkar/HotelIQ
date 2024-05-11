package com.example.hotel;


import android.content.*;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class MyDbHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "CustomerMst.db";
    public static final String Tab = "CusTab";

    private static final String COL0 = "cuid";
    private static final String COL1 = "cuname";
    private static final String COL2 = "cuphone";
    private static final String COL3 = "cuadd";
    private static final String COL4 = "cucity";
    private static final String COL5 = "cupost";
    private static final String COL6 = "cuzender";
    private static final String COL7 = "cumail";
    private static final String COL8 = "cuadhar";

    String query = "CREATE TABLE " + Tab + " ("
            + COL0 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL1 + " TEXT,"
            + COL2 + " TEXT,"
            + COL3 + " TEXT,"
            + COL4 + " TEXT,"
            + COL5 + " TEXT,"
            + COL6 + " TEXT,"
            + COL7 + " TEXT,"
            + COL8 + " TEXT)";

    public MyDbHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Tab);
        onCreate(db);
    }


    public boolean addData(String cuid, String cuname, String cuphone, String cucity, String cupost, String cuadd, String cuzender, String cumail, String cuadhar) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL0, cuid);
        contentValues.put(COL1, cuname);
        contentValues.put(COL2, cuphone);
        contentValues.put(COL3, cucity);
        contentValues.put(COL4, cupost);
        contentValues.put(COL5, cuadd);
        contentValues.put(COL6, cuzender);
        contentValues.put(COL7, cumail);
        contentValues.put(COL8, cuadhar);
        long result = db.insert(Tab, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

        }

        public ArrayList<Model> fetchCustomerDetails(){
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from "+Tab, null);

            ArrayList<Model> customerArray = new ArrayList<>();

            while (cursor.moveToNext())
            {
                Model customerModel = new Model();

                customerModel.setId(cursor.getInt(0));
                customerModel.setName(cursor.getString(1));
                customerModel.setPhone(cursor.getString(2));
                customerModel.setAdd(cursor.getString(3));
                customerModel.setCity(cursor.getString(4));
                customerModel.setPostal(cursor.getString(5));
                customerModel.setZender(cursor.getString(6));
                customerModel.setMail(cursor.getString(7));
                customerModel.setAdhar(cursor.getString(8));

                customerArray.add(customerModel);
            }

            return customerArray;
        }

        public void deleteCustomer(int id)
        {
            SQLiteDatabase database = this.getWritableDatabase();
            database.delete(Tab,COL0+ " = ? ", new String[]{String.valueOf(id)});
        }

        public void updateCustomer(Model model){

            SQLiteDatabase database = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(COL1, model.getName());
            contentValues.put(COL2, model.getPhone());
            contentValues.put(COL3, model.getAdd());
            contentValues.put(COL4, model.getCity());
            contentValues.put(COL5, model.getPostal());
            contentValues.put(COL6, model.getZender());
            contentValues.put(COL7, model.getMail());
            contentValues.put(COL8, model.getAdhar());

            database.update(Tab, contentValues, COL0 +" = "+model.getId(),null);

        }

        public boolean checkCustomerId(int id)
        {
            SQLiteDatabase database = this.getReadableDatabase();
            Cursor cursor = database.rawQuery("select * from "+Tab, null);

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

