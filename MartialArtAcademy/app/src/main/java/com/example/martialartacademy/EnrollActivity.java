package com.example.martialartacademy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EnrollActivity extends AppCompatActivity {

    private EditText  studentIDEdit;
    private EditText enrolldateEdit;
    private EditText expireddateEdit;
    private EditText closingdateEdit;

    private Button backenrollBtn;
    private Button nextenrollBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll);

        studentIDEdit = findViewById(R.id.studentIDEdit);
        enrolldateEdit= findViewById(R.id.studentIDEdit);
        expireddateEdit = findViewById(R.id.expireddateEdit);
        closingdateEdit = findViewById(R.id.closingdateEdit);

        backenrollBtn = findViewById(R.id.backenrollBtn);
        backenrollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        nextenrollBtn = findViewById(R.id.nextenrollBtn);
        nextenrollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
