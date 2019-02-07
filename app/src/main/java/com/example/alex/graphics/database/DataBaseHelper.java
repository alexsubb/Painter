package com.example.alex.graphics.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DataBaseHelper {
    private static DataBaseHelper helper;
    private DBhelper dbHelper;
    private SQLiteDatabase database  ;
    private ContentValues contentValues ;
    private DataBaseHelper(Context context){
        dbHelper = new DBhelper(context);
        database = dbHelper.getWritableDatabase();
        contentValues = new ContentValues();
    }
    public static DataBaseHelper getInstance(Context context){
        if (helper == null){
            helper = new DataBaseHelper(context);
        }
        return helper;
    }
    public  void add (String p)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBhelper.KEY_WORD, p);
        database.insert(DBhelper.TABLE_CONTACTS, null, contentValues);
    }
    public ArrayList<String> allElement(){
        ArrayList<String> dictionary = new ArrayList<>();
        Cursor cursor = database.query(DBhelper.TABLE_CONTACTS,null,null,null,null,null,null);

        if(cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
            int wordIndex = cursor.getColumnIndex(DBhelper.KEY_WORD);
            do{
                dictionary.add(cursor.getString(wordIndex));
            }while (cursor.moveToNext() );
        }
        cursor.close();
        return dictionary ;
    }
    public void remove (String id){
        //database.delete(DBHelper.TABLE_CONTACTS, null, null);
        int delCount = database.delete(DBhelper.TABLE_CONTACTS, DBhelper.KEY_WORD + "= " + id, null);
        Log.d("mLog", "deleted rows count = " + delCount);
    }

    public  void close(){
        dbHelper.close();
    }
}
