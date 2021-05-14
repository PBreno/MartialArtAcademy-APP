package com.example.martialartacademy.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.martialartacademy.database.model.UserModel;

public class DBHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco.db";
    private static final int VERSAO_BANCO =2;

    public DBHelper(Context context) {
        super(context,NOME_BANCO, null, VERSAO_BANCO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UserModel.DROP_TABLE);
        db.execSQL(UserModel.CREATE_TABLE);
    }
}
