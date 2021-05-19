package com.example.martialartacademy.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.martialartacademy.database.DBHelper;
import com.example.martialartacademy.database.model.EnrollModel;
import com.example.martialartacademy.database.model.GraduationModel;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EnrollDAO extends AbstrataDAO{

    private String[] column =
    {
        EnrollModel.COLUMN_ENROLL_ID,
        EnrollModel.COLUMN_STUDENT_Id,
        EnrollModel.COLUMN_ENROLL_DATE,
        EnrollModel.COLUMN_EXPIRED_DAY,
        EnrollModel.COLUMN_CLOSING_DATE
    };

    public  EnrollDAO (Context context){
        db_Helper = new DBHelper(context);
    }

    public long Insert (final EnrollModel enroll){

        Open();

        ContentValues values = new ContentValues();

        values.put(EnrollModel.COLUMN_STUDENT_Id, enroll.getStudent_id());
        values.put( EnrollModel.COLUMN_ENROLL_DATE, String.valueOf(enroll.getEnroll_date()));
        values.put(EnrollModel.COLUMN_EXPIRED_DAY, enroll.getExpired_day());
        values.put( EnrollModel.COLUMN_CLOSING_DATE, String.valueOf(enroll.getClosing_date()));

        long retorno = db.insert(EnrollModel.TABLE_NAME, null, values);

        Close();

        return retorno;
    }

    public long Delete (final Integer student_id){

        Open();

        long retorno = db.delete(EnrollModel.TABLE_NAME, EnrollModel.COLUMN_STUDENT_Id + " = ?", new String[]{String.valueOf(student_id)});

        Close();
        return retorno;
    }

    public long DeleteAll(){

        Open();

        long retorno = db.delete(EnrollModel.TABLE_NAME,null, null);

        Close();
        return retorno;
    }
    public  long Update ( final Integer student_id, final Date enroll_Date , final Integer expired_day, final Date closing_date) {

        Open();

        ContentValues values = new ContentValues();
        values.put(EnrollModel.COLUMN_ENROLL_DATE, String.valueOf(enroll_Date));
        values.put(EnrollModel.COLUMN_EXPIRED_DAY, expired_day);
        values.put(EnrollModel.COLUMN_CLOSING_DATE, String.valueOf(closing_date));

        long retorno = db.update(EnrollModel.TABLE_NAME,values, EnrollModel.COLUMN_STUDENT_Id + " = ?" ,  new String[]{String.valueOf(student_id)});

        Close();
        return retorno;
    }

    public ArrayList<EnrollModel> SelectAll(){

        Open();

        ArrayList<EnrollModel> arlgraduation = new ArrayList<EnrollModel>();

        Cursor cursor = db.query(EnrollModel.TABLE_NAME, column, null, null,null,null,null);

        cursor.moveToNext();
        while (!cursor.isAfterLast()){

            EnrollModel enroll = new EnrollModel();
            enroll.setId(cursor.getLong(cursor.getColumnIndex(EnrollModel.COLUMN_ENROLL_ID)));
            enroll.setStudent_id(cursor.getInt(cursor.getColumnIndex(EnrollModel.COLUMN_STUDENT_Id)));
            enroll.setEnroll_date(Date.valueOf(cursor.getString(cursor.getColumnIndex(EnrollModel.COLUMN_ENROLL_DATE))));
            enroll.setExpired_day(cursor.getInt(cursor.getColumnIndex(EnrollModel.COLUMN_EXPIRED_DAY)));
            enroll.setClosing_date(Date.valueOf(cursor.getString(cursor.getColumnIndex(EnrollModel.COLUMN_CLOSING_DATE))));

            arlgraduation.add(enroll);

            cursor.moveToNext();
        }

        Close();
        return arlgraduation;
    }
}
