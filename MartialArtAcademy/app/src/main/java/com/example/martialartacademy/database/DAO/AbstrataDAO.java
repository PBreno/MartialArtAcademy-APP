package com.example.martialartacademy.database.DAO;

import android.database.sqlite.SQLiteDatabase;

import com.example.martialartacademy.database.DBHelper;

public abstract class AbstrataDAO {

    protected SQLiteDatabase db;
    protected DBHelper db_Helper;

    protected final void Open (){
        db = db_Helper.getWritableDatabase();
    }

    protected final void Close() {
        db_Helper.close();
    }
}
