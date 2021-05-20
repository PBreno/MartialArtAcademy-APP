package com.example.martialartacademy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GraduationActivity extends AppCompatActivity {

    private EditText modalityGraEdit;
    private EditText graduationEdit;

    private Button backgrdBtn;
    private Button nextgrdBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graduation);

        modalityGraEdit = findViewById(R.id.modalityEdit);
        graduationEdit = findViewById(R.id.graduationEdit);

        backgrdBtn = findViewById(R.id.backgrdBtn);
        backgrdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        nextgrdBtn = findViewById(R.id.nextgrdBtn);
        nextgrdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(GraduationActivity.this, PlanActivity.class));

            }
        });
    }
}
