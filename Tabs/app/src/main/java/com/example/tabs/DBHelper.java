package com.example.tabs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {



    private static final String dbName = "ToDoList";
    private static final String Table_name1 = "urgent";
    private static final String COL0 = "id";
    private static final String COL1 = "item";



    public DBHelper(Context context){
        super(context, Table_name1, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create = "create table " + Table_name1 + " (id integer primary key autoincrement , " + COL1 + " TEXT )";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    public boolean addUser(String name){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv  = new ContentValues();

        cv.put(COL1, name);


        long result = db.insert(Table_name1,null,cv);

        if(result == -1)
            return false;
        else
            return true;




    }


    public Cursor getData(){

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "select * from "+ Table_name1 ;

        Cursor data = db.rawQuery(sql,null);

        return data;

    }

}
