package com.example.martialartacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.martialartacademy.adapter.ListMainAdapter;
import com.example.martialartacademy.database.model.ModalityModel;
import com.example.martialartacademy.database.model.PlanModel;
import com.example.martialartacademy.database.model.StudentModel;
import com.example.martialartacademy.database.model.UserModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.List);

        ArrayList<StudentModel> studentlist = new ArrayList<StudentModel>();
        ArrayList<ModalityModel> modalitylist = new ArrayList<ModalityModel>();
        ArrayList<PlanModel> planlist = new ArrayList<PlanModel>();
        ListAdapter adapter = new ListMainAdapter(MainActivity.this,studentlist, modalitylist,planlist);
        list.setAdapter(adapter);


    }
}