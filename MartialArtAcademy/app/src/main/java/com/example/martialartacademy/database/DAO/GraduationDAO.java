package com.example.martialartacademy.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.martialartacademy.database.DBHelper;
import com.example.martialartacademy.database.model.GraduationModel;
import com.example.martialartacademy.database.model.ModalityModel;

import java.util.ArrayList;

public class GraduationDAO extends AbstrataDAO{

    private String[] column =
    {
            GraduationModel.COLUMN_MODALITY,
            GraduationModel.COLUMN_GRADUATION
    };

    public  GraduationDAO (Context context){
        db_Helper = new DBHelper(context);
    }

    public long Insert (final GraduationModel graduation){

        Open();

        ContentValues values = new ContentValues();

        values.put(GraduationModel.COLUMN_MODALITY, graduation.getModality());
        values.put(GraduationModel.COLUMN_GRADUATION, graduation.getGraduation());

        long retorno = db.insert(GraduationModel.TABLE_NAME, null, values);

        Close();

        return retorno;
    }

    public long Delete (final String graduation){

        Open();

        long retorno = db.delete(GraduationModel.TABLE_NAME, GraduationModel.COLUMN_GRADUATION + " = ?", new String[]{graduation});

        Close();
        return retorno;
    }

    public long DeleteAll(){

        Open();

        long retorno = db.delete(GraduationModel.TABLE_NAME,null, null);

        Close();
        return retorno;
    }
    public  long Update ( final String graduation) {

        Open();

        ContentValues values = new ContentValues();
        values.put(GraduationModel.COLUMN_GRADUATION, graduation);

        long retorno = db.update(GraduationModel.TABLE_NAME,values, GraduationModel.COLUMN_GRADUATION + " = ?" , new String[]{graduation});

        Close();
        return retorno;
    }

    public ArrayList<GraduationModel> SelectAll(){

        Open();

        ArrayList<GraduationModel> arlgraduation = new ArrayList<GraduationModel>();

        Cursor cursor = db.query(GraduationModel.TABLE_NAME, column, null, null,null,null,null);

        cursor.moveToNext();
        while (!cursor.isAfterLast()){

            GraduationModel graduation = new GraduationModel();
            graduation.setModality(cursor.getString(cursor.getColumnIndex(GraduationModel.COLUMN_MODALITY)));
            graduation.setGraduation(cursor.getString(cursor.getColumnIndex(GraduationModel.COLUMN_GRADUATION)));
            arlgraduation.add(graduation);

            cursor.moveToNext();
        }

        Close();
        return arlgraduation;
    }

    public GraduationModel Select (final  String graduation){

        Open();

        GraduationModel grad = null;
        Cursor cursor = db.query(GraduationModel.TABLE_NAME,column, GraduationModel.COLUMN_GRADUATION + " = ? ", new String[] {graduation} , null, null, null);
        cursor.moveToNext();

        if (cursor.moveToFirst()){
            grad = new GraduationModel();
            grad.setGraduation(cursor.getString(cursor.getColumnIndex(GraduationModel.COLUMN_GRADUATION)));

        }
        cursor.close();

        Close();

        return grad;
    }

}
