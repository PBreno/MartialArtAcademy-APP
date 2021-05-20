package com.example.martialartacademy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PlanActivity extends AppCompatActivity {

    private EditText modalityPlnEdit;
    private EditText planEdit;
    private EditText monthlyValueEdit;

    private Button backplnBtn;
    private  Button  nextplnBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);


        modalityPlnEdit = findViewById(R.id.modalityPlnEdit);
        planEdit= findViewById(R.id.planEdit);
        monthlyValueEdit = findViewById(R.id.monthlyValueEdit);

        backplnBtn = findViewById(R.id.backplnBtn);
        backplnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        nextplnBtn = findViewById(R.id.nextplnBtn);
        nextplnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}
