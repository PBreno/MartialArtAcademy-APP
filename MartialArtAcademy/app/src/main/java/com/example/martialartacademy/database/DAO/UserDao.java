package com.example.martialartacademy.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.martialartacademy.database.DBHelper;
import com.example.martialartacademy.database.model.UserModel;

import java.util.ArrayList;

public class UserDAO extends AbstrataDAO{

    private String[] columns =
    {
            UserModel.COLUMN_ID,
            UserModel.COLUMN_USER,
            UserModel.COLUMN_PASSWORD
    };

    public UserDAO(Context context){
        db_Helper = new DBHelper(context);
    }

    public long Insert (final UserModel model){

        Open();

        ContentValues values = new ContentValues();
        values.put(UserModel.COLUMN_USER, model.getNm_user());
        values.put(UserModel.COLUMN_PASSWORD, model.getDs_password());

        long retorno = db.insert(UserModel.TABLE_NAME, null, values);

        Close();

        return retorno;
    }

    public ArrayList<UserModel> selectAll(){

        Open();

        ArrayList<UserModel> userList = new ArrayList<>();

        Cursor cursor = db.query(UserModel.CREATE_TABLE, columns, null,null,null,null,null);
        cursor.moveToNext();

        while (!cursor.isAfterLast()){

            UserModel model = new UserModel();
            model.setId(cursor.getLong(cursor.getColumnIndex(UserModel.COLUMN_ID)));
            model.setNm_user(cursor.getString(cursor.getColumnIndex(UserModel.COLUMN_USER)));
            model.setDs_password(cursor.getString(cursor.getColumnIndex(UserModel.COLUMN_PASSWORD)));
            userList.add(model);
            cursor.moveToNext();

        }

        cursor.close();

        Close();

        return userList;
    }

    public UserModel Select (final String user, final String password){

        Open();

        UserModel usr = null;

        Cursor cursor = db.query(UserModel.TABLE_NAME, columns, UserModel.COLUMN_USER + " = ? AND " + UserModel.COLUMN_PASSWORD + " = ?", new String[] {user, password}, null, null, null);
        cursor.moveToNext();

        if (cursor.moveToFirst()){

            usr = new UserModel();
            usr.setId(cursor.getLong(cursor.getColumnIndex(UserModel.COLUMN_ID)));
            usr.setNm_user(cursor.getString(cursor.getColumnIndex(UserModel.COLUMN_USER)));
            usr.setDs_password(cursor.getString(cursor.getColumnIndex(UserModel.COLUMN_PASSWORD)));
        }
        cursor.close();

        Close();

        return usr;
    }
}
