package com.example.martialartacademy.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.martialartacademy.database.DBHelper;
import com.example.martialartacademy.database.model.GraduationModel;
import com.example.martialartacademy.database.model.PlanModel;

import java.util.ArrayList;

public class PlanDAO extends AbstrataDAO{

    private String[] column =
    {
            PlanModel.COLUMN_MODALITY,
            PlanModel.COLUMN_PLAN,
            PlanModel.COLUMN_MONTHYVALUE
    };

    public  PlanDAO (Context context){
        db_Helper = new DBHelper(context);
    }

    public long Insert (final PlanModel plan){

        Open();

        ContentValues values = new ContentValues();

        values.put(PlanModel.COLUMN_MODALITY, plan.getModality());
        values.put(PlanModel.COLUMN_PLAN, plan.getPlan());
        values.put(PlanModel.COLUMN_MONTHYVALUE, plan.getMonthyvalue());

        long retorno = db.insert(GraduationModel.TABLE_NAME, null, values);

        Close();

        return retorno;
    }

    public long Delete (final String plan){

        Open();

        long retorno = db.delete(PlanModel.TABLE_NAME, PlanModel.COLUMN_PLAN + " = ?", new String[]{plan});

        Close();
        return retorno;
    }

    public long DeleteAll(){

        Open();

        long retorno = db.delete(PlanModel.TABLE_NAME,null, null);

        Close();
        return retorno;
    }

    public  long Update ( final String plan) {

        Open();

        ContentValues values = new ContentValues();
        values.put(PlanModel.COLUMN_PLAN, plan);

        long retorno = db.update(PlanModel.TABLE_NAME,values, PlanModel.COLUMN_PLAN + " = ?" , new String[]{plan});

        Close();
        return retorno;
    }

    public ArrayList<PlanModel> SelectAll(){

        Open();

        ArrayList<PlanModel> arlplan = new ArrayList<PlanModel>();

        Cursor cursor = db.query(PlanModel.TABLE_NAME, column, null, null,null,null,null);

        cursor.moveToNext();
        while (!cursor.isAfterLast()){

            PlanModel plan = new PlanModel();
            plan.setModality(cursor.getString(cursor.getColumnIndex(PlanModel.COLUMN_MODALITY)));
            plan.setPlan(cursor.getString(cursor.getColumnIndex(PlanModel.COLUMN_PLAN)));
            plan.setMonthyvalue(cursor.getDouble(cursor.getColumnIndex(PlanModel.COLUMN_MONTHYVALUE)));
            arlplan.add(plan);

            cursor.moveToNext();
        }

        Close();
        return arlplan;
    }
}
