package com.example.martialartacademy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EnrollModalityActivity extends AppCompatActivity {

    private EditText modalityermbEdit;
    private EditText graduationermbEdit;
    private EditText datestartEdit;
    private EditText dateendEdit;
    private EditText planEdit;

    private Button backenrollmdtBtn;
    private Button nextenrollmdtBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_mobility);

        modalityermbEdit = findViewById(R.id.modalityermbEdit);
        graduationermbEdit = findViewById(R.id.graduationermbEdit);
        datestartEdit = findViewById(R.id.datestartEdit);
        dateendEdit = findViewById(R.id.dateendEdit);
        planEdit = findViewById(R.id.planEdit);

        backenrollmdtBtn = findViewById(R.id.backenrollmdtBtn);
        backenrollmdtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        nextenrollmdtBtn = findViewById(R.id.nextenrollmdtBtn);
        nextenrollmdtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
