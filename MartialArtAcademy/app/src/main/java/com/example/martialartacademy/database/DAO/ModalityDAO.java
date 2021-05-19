package com.example.martialartacademy.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.martialartacademy.database.DBHelper;
import com.example.martialartacademy.database.model.ModalityModel;

import java.util.ArrayList;

public class ModalityDAO extends AbstrataDAO{

    private String[]  column =
    {
            ModalityModel.COLUMN_MODALITY
    };

    public ModalityDAO(Context context){

        db_Helper = new DBHelper(context);
    }

    public long Insert (final ModalityModel modality){

        Open();

        ContentValues values = new ContentValues();

        values.put(ModalityModel.COLUMN_MODALITY, modality.getMobility());

        long retorno = db.insert(ModalityModel.TABLE_NAME, null, values);

        Close();

        return retorno;
    }

    public long Delete (final String modality){

        Open();

        long retorno = db.delete(ModalityModel.TABLE_NAME, ModalityModel.COLUMN_MODALITY + " = ?", new String[]{modality});

        Close();
        return retorno;
    }

    public long DeleteAll(){

        Open();

        long retorno = db.delete(ModalityModel.TABLE_NAME,null, null);

        Close();
        return retorno;
    }
    public  long Update ( final String modality) {

        Open();

        ContentValues values = new ContentValues();
        values.put(ModalityModel.COLUMN_MODALITY, modality);

        long retorno = db.update(ModalityModel.TABLE_NAME,values, ModalityModel.COLUMN_MODALITY + " = ?" , new String[]{modality});

        Close();
        return retorno;
    }

    public ArrayList<ModalityModel> SelectAll(){

        Open();

        ArrayList<ModalityModel> arlmodality = new ArrayList<ModalityModel>();

        Cursor cursor = db.query(ModalityModel.TABLE_NAME, column, null, null,null,null,null);

        cursor.moveToNext();
        while (!cursor.isAfterLast()){

            ModalityModel modality = new ModalityModel();
            modality.setMobility(cursor.getString(cursor.getColumnIndex(ModalityModel.COLUMN_MODALITY)));

            arlmodality.add(modality);

            cursor.moveToNext();
        }

        Close();
        return arlmodality;
    }
}
