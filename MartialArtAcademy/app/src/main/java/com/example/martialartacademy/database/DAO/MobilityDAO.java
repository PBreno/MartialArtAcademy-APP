package com.example.martialartacademy.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.martialartacademy.database.DBHelper;
import com.example.martialartacademy.database.model.MobilityModel;
import com.example.martialartacademy.database.model.StudentModel;

import java.util.ArrayList;

public class MobilityDAO extends AbstrataDAO{

    private String[]  column =
    {
            MobilityModel.COLUMN_MOBILITY
    };

    public  MobilityDAO (Context context){

        db_Helper = new DBHelper(context);
    }

    public long Insert (final MobilityModel mobility){

        Open();

        ContentValues values = new ContentValues();

        values.put(MobilityModel.COLUMN_MOBILITY, mobility.getMobility());

        long retorno = db.insert(MobilityModel.TABLE_NAME, null, values);

        Close();

        return retorno;
    }

    public long Delete (final String mobility){

        Open();

        long retorno = db.delete(MobilityModel.TABLE_NAME,MobilityModel.COLUMN_MOBILITY + " = ?", new String[]{mobility});

        Close();
        return retorno;
    }

    public long DeleteAll(){

        Open();

        long retorno = db.delete(MobilityModel.TABLE_NAME,null, null);

        Close();
        return retorno;
    }
    public  long Update ( final String mobility) {

        Open();

        ContentValues values = new ContentValues();
        values.put(MobilityModel.COLUMN_MOBILITY, mobility);

        long retorno = db.update(MobilityModel.TABLE_NAME,values, MobilityModel.COLUMN_MOBILITY + " = ?" , new String[]{mobility});

        Close();
        return retorno;
    }

    public ArrayList<MobilityModel> SelectAll(){

        Open();

        ArrayList<MobilityModel> arlmobility = new ArrayList<MobilityModel>();

        Cursor cursor = db.query(MobilityModel.TABLE_NAME, column, null, null,null,null,null);

        cursor.moveToNext();
        while (!cursor.isAfterLast()){

            MobilityModel mobility = new MobilityModel();
            mobility.setMobility(cursor.getString(cursor.getColumnIndex(MobilityModel.COLUMN_MOBILITY)));

            arlmobility.add(mobility);

            cursor.moveToNext();
        }

        Close();
        return arlmobility;
    }
}
