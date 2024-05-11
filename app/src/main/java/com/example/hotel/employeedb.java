package com.example.hotel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class employeedb extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "empMst.db";

    // employee table


    private static final String eTab = "empdet";

    private static final String eCOL0 = "emid";
    private static final String eCOL1 = "emname";
    private static final String eCOL2 = "emphone";
    private static final String eCOL3 = "emadd";
    private static final String eCOL4 = "empost";
    private static final String eCOL5 = "emsalary";


    public employeedb(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        String query2 = "CREATE TABLE " + eTab + " ("
                + eCOL0 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + eCOL1 + " TEXT,"
                + eCOL2 + " TEXT,"
                + eCOL3 + " TEXT,"
                + eCOL4 + " TEXT,"
        + eCOL5 + " TEXT)";
        db.execSQL(query2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + eTab);
        onCreate(db);
    }

    public boolean eaddData(String emid, String emname, String emphone, String emadd, String empost, String emsalary) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(eCOL0, emid);
        content.put(eCOL1, emname);
        content.put(eCOL2, emphone);
        content.put(eCOL3, emadd);
        content.put(eCOL4, empost);
        content.put(eCOL5, emsalary);

        long result = db.insert(eTab, null, content);
        if (result == -1) {
            return false;
        }
        else{
            return true;
        }

    }
    public ArrayList<EmployeeModel> fetchEmployeeDetails(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+eTab, null);

        ArrayList<EmployeeModel> employeeArray = new ArrayList<>();

        while (cursor.moveToNext())
        {
            EmployeeModel employeeModel = new EmployeeModel();

            employeeModel.setEmid(cursor.getInt(0));
            employeeModel.setEmname(cursor.getString(1));
            employeeModel.setEmphone(cursor.getString(2));
            employeeModel.setEmadd(cursor.getString(3));
            employeeModel.setEmpost(cursor.getString(4));
            employeeModel.setEmsalary(cursor.getString(5));

            employeeArray.add(employeeModel);
        }

        return employeeArray;
    }

    public void deleteEmployee(int id)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(eTab,eCOL0+ " = ? ", new String[]{String.valueOf(id)});
    }

    public void updateEmployee(EmployeeModel employeeModel){

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(eCOL1, employeeModel.getEmname());
        contentValues.put(eCOL2, employeeModel.getEmphone());
        contentValues.put(eCOL3, employeeModel.getEmadd());
        contentValues.put(eCOL4, employeeModel.getEmpost());
        contentValues.put(eCOL5, employeeModel.getEmsalary());

        database.update(eTab, contentValues, eCOL0 +" = "+employeeModel.getEmid(),null);

    }

    public boolean checkEmployeeId(int id)
    {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from "+eTab, null);

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