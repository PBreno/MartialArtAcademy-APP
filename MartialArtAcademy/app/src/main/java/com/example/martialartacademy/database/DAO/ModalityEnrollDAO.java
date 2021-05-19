package com.example.martialartacademy.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.martialartacademy.database.DBHelper;
import com.example.martialartacademy.database.model.ModalityEnrollModel;
import com.example.martialartacademy.database.model.StudentModel;

import java.sql.Date;
import java.util.ArrayList;

public class ModalityEnrollDAO  extends AbstrataDAO{

    private String[] column ={

            ModalityEnrollModel.COLUMN_ID,
            ModalityEnrollModel.COLUMN_MODALITY,
            ModalityEnrollModel.COLUMN_GRADUATION,
            ModalityEnrollModel.COLUMN_BEGIN_DATE,
            ModalityEnrollModel.COLUMN_END_DATE,
            ModalityEnrollModel.COLUMN_PLAN
    };

    public ModalityEnrollDAO(Context context){
        db_Helper = new DBHelper(context);
    }

    public long Insert(final ModalityEnrollModel modalityEnroll ){

        Open();

        ContentValues values = new ContentValues();
        values.put(ModalityEnrollModel.COLUMN_MODALITY, modalityEnroll.getModality());
        values.put(ModalityEnrollModel.COLUMN_GRADUATION, modalityEnroll.getGraduation());
        values.put(ModalityEnrollModel.COLUMN_BEGIN_DATE, (String.valueOf(modalityEnroll.getBegin_date())));
        values.put(ModalityEnrollModel.COLUMN_END_DATE,(String.valueOf(modalityEnroll.getEnd_date())));
        values.put(ModalityEnrollModel.COLUMN_PLAN, modalityEnroll.getPlan());

        long retorno = db.insert(StudentModel.TABLE_NAME, null, values);

        Close();

        return retorno;
    }

    public long Delete (final String modality){

        Open();

        long retorno = db.delete(ModalityEnrollModel.TABLE_NAME,ModalityEnrollModel.COLUMN_MODALITY + " = ?", new String[]{modality});

        Close();
        return retorno;
    }

    public long DeleteAll(){

        Open();

        long retorno = db.delete(ModalityEnrollModel.TABLE_NAME,null, null);

        Close();
        return retorno;
    }

    public  long Update (final String modality, final String graduation, final Date begin_date, final Date end_date, final String plan) {

        Open();

        ContentValues values = new ContentValues();
        values.put(ModalityEnrollModel.COLUMN_GRADUATION, graduation);
        values.put(ModalityEnrollModel.COLUMN_BEGIN_DATE, String.valueOf(begin_date));
        values.put(ModalityEnrollModel.COLUMN_END_DATE, String.valueOf(end_date));
        values.put(ModalityEnrollModel.COLUMN_PLAN, plan);

        long retorno = db.update(ModalityEnrollModel.TABLE_NAME,values, ModalityEnrollModel.COLUMN_MODALITY + " = ?" , new String[]{modality});

        Close();
        return retorno;
    }

    public ArrayList<ModalityEnrollModel> SelectAll(){

        Open();

        ArrayList<ModalityEnrollModel> arlmodalityEnroll = new ArrayList<ModalityEnrollModel>();

        Cursor cursor = db.query(ModalityEnrollModel.TABLE_NAME, column, null, null,null,null,null);

        cursor.moveToNext();
        while (!cursor.isAfterLast()){

            ModalityEnrollModel modalityEnroll = new ModalityEnrollModel();
            modalityEnroll.setId(cursor.getLong(cursor.getColumnIndex(ModalityEnrollModel.COLUMN_ID)));
            modalityEnroll.setModality(cursor.getString(cursor.getColumnIndex(ModalityEnrollModel.COLUMN_MODALITY)));
            modalityEnroll.setGraduation(cursor.getString(cursor.getColumnIndex(ModalityEnrollModel.COLUMN_GRADUATION)));
            modalityEnroll.setBegin_date(Date.valueOf(cursor.getString(cursor.getColumnIndex(ModalityEnrollModel.COLUMN_BEGIN_DATE))));
            modalityEnroll.setEnd_date(Date.valueOf(cursor.getString(cursor.getColumnIndex(ModalityEnrollModel.COLUMN_END_DATE))));
            modalityEnroll.setPlan(cursor.getString(cursor.getColumnIndex(ModalityEnrollModel.COLUMN_PLAN)));

            arlmodalityEnroll.add(modalityEnroll);

            cursor.moveToNext();
        }

        Close();
        return arlmodalityEnroll;
    }
}
