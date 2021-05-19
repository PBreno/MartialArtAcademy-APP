package com.example.martialartacademy.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.martialartacademy.database.DBHelper;
import com.example.martialartacademy.database.model.GraduationModel;
import com.example.martialartacademy.database.model.PlanModel;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PlanDAO extends AbstrataDAO{

    private String[] column =
    {
            PlanModel.COLUMN_MODALITY,
            PlanModel.COLUMN_PLAN,
            PlanModel.COLUMN_MONTHLYVALUE
    };

    public  PlanDAO (Context context){
        db_Helper = new DBHelper(context);
    }

    public long Insert (final PlanModel plan){

        Open();

        ContentValues values = new ContentValues();

        values.put(PlanModel.COLUMN_MODALITY, plan.getModality());
        values.put(PlanModel.COLUMN_PLAN, plan.getPlan());
        values.put(PlanModel.COLUMN_MONTHLYVALUE, String.valueOf(plan.getMonthlyvalue()));

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

    public  long Update ( final String plan, final BigDecimal monthlyvalue) {

        Open();

        ContentValues values = new ContentValues();
        values.put(PlanModel.COLUMN_PLAN, plan);
        values.put(PlanModel.COLUMN_MONTHLYVALUE, String.valueOf(monthlyvalue));

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
            plan.setMonthlyvalue(BigDecimal.valueOf(cursor.getDouble(cursor.getColumnIndex(PlanModel.COLUMN_MONTHLYVALUE))));
            arlplan.add(plan);

            cursor.moveToNext();
        }

        Close();
        return arlplan;
    }
}
