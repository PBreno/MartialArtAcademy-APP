package com.example.martialartacademy.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.martialartacademy.database.DBHelper;
import com.example.martialartacademy.database.model.StudentModel;

import java.util.ArrayList;

public class StudentDAO extends AbstrataDAO{

    private String[] column ={

            StudentModel.COLUMN_ID,
            StudentModel.COLUMN_NAME,
            StudentModel.COLUMN_CPF,
            StudentModel.COLUMN_GENDER,
            StudentModel.COLUMN_BIRTH,
            StudentModel.COLUMN_EMAIL,
            StudentModel.COLUMN_PHONE,
            StudentModel.COLUMN_EMAIL,
            StudentModel.COLUMN_CEP
    };

    public StudentDAO(Context context){
        db_Helper = new DBHelper(context);
    }

    public long Insert(final StudentModel student ){

        Open();

        ContentValues values = new ContentValues();
        values.put(StudentModel.COLUMN_NAME, student.getName());
        values.put(StudentModel.COLUMN_CPF, student.getCpf());
        values.put(StudentModel.COLUMN_GENDER, student.getGender());
        values.put(StudentModel.COLUMN_BIRTH,student.getBirth());
        values.put(StudentModel.COLUMN_EMAIL, student.getEmail());
        values.put(StudentModel.COLUMN_PHONE, student.getPhone());
        values.put(StudentModel.COLUMN_EMAIL, student.getEmail());
        values.put(StudentModel.COLUMN_CEP, student.getCep());

        long retorno = db.insert(StudentModel.TABLE_NAME, null, values);

        Close();

        return retorno;
    }

    public long Delete (final String cpf){

        Open();

        long retorno = db.delete(StudentModel.TABLE_NAME,StudentModel.COLUMN_CPF + " = ?", new String[]{cpf});

        Close();
        return retorno;
    }

    public long DeleteAll(){

        Open();

        long retorno = db.delete(StudentModel.TABLE_NAME,null, null);

        Close();
        return retorno;
    }

    public  long Update (final String name, final String cpf, final String gender, final String birth, final String email, final String phone, final String address, final String cep) {

        Open();

        ContentValues values = new ContentValues();
        values.put(StudentModel.COLUMN_NAME, name);
        values.put(StudentModel.COLUMN_CPF, cpf);
        values.put(StudentModel.COLUMN_GENDER, gender);
        values.put(StudentModel.COLUMN_BIRTH, birth);
        values.put(StudentModel.COLUMN_EMAIL, email);
        values.put(StudentModel.COLUMN_PHONE, phone);
        values.put(StudentModel.COLUMN_ADDRESS, address);
        values.put(StudentModel.COLUMN_CEP, cep);

        long retorno = db.update(StudentModel.TABLE_NAME,values, StudentModel.COLUMN_NAME + " = ?" , new String[]{name});

        Close();
        return retorno;
    }

    public ArrayList<StudentModel> SelectAll(){

        Open();

        ArrayList<StudentModel> arlstudent = new ArrayList<StudentModel>();

        Cursor cursor = db.query(StudentModel.TABLE_NAME, column, null, null,null,null,null);

        cursor.moveToNext();
        while (!cursor.isAfterLast()){

            StudentModel student = new StudentModel();
            student.setId(cursor.getLong(cursor.getColumnIndex(StudentModel.COLUMN_ID)));
            student.setName(cursor.getString(cursor.getColumnIndex(StudentModel.COLUMN_NAME)));
            student.setCpf(cursor.getString(cursor.getColumnIndex(StudentModel.COLUMN_CPF)));
            student.setGender(cursor.getString(cursor.getColumnIndex(StudentModel.COLUMN_GENDER)));
            student.setBirth(cursor.getString(cursor.getColumnIndex(StudentModel.COLUMN_BIRTH)));
            student.setEmail(cursor.getString(cursor.getColumnIndex(StudentModel.COLUMN_EMAIL)));
            student.setPhone(cursor.getString(cursor.getColumnIndex(StudentModel.COLUMN_PHONE)));
            student.setAddress(cursor.getString(cursor.getColumnIndex(StudentModel.COLUMN_ADDRESS)));
            student.setCep(cursor.getString(cursor.getColumnIndex(student.COLUMN_CEP)));
            arlstudent.add(student);

            cursor.moveToNext();
        }

        Close();
        return arlstudent;
    }
}
