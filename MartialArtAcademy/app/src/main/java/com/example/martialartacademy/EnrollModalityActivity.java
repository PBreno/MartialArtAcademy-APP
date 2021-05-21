package com.example.martialartacademy;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.DateFormatSymbols;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.martialartacademy.database.DAO.EnrollDAO;
import com.example.martialartacademy.database.DAO.GraduationDAO;
import com.example.martialartacademy.database.DAO.ModalityDAO;
import com.example.martialartacademy.database.DAO.ModalityEnrollDAO;
import com.example.martialartacademy.database.model.ModalityEnrollModel;

import java.util.Date;

public class EnrollModalityActivity extends AppCompatActivity {

    private EditText modalityermbEdit;
    private EditText graduationermbEdit;
    private EditText datestartEdit;
    private EditText dateendEdit;
    private EditText planEnrollModalityEdit;

    private Button backenrollmdtBtn;
    private Button nextenrollmdtBtn;
    private ModalityEnrollDAO modalityenrolldao;
    private ModalityDAO modalitydao;
    private GraduationDAO gradao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_mobility);

        gradao = new GraduationDAO(this);
        modalitydao = new ModalityDAO(this);
        modalityenrolldao = new ModalityEnrollDAO(this);

        modalityermbEdit = findViewById(R.id.modalityermbEdit);
        graduationermbEdit = findViewById(R.id.graduationermbEdit);
        datestartEdit = findViewById(R.id.datestartEdit);
        dateendEdit = findViewById(R.id.dateendEdit);
        planEnrollModalityEdit = findViewById(R.id.planEnrollModalityEdit);

        backenrollmdtBtn = findViewById(R.id.backenrollmdtBtn);
        backenrollmdtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(EnrollModalityActivity.this, EnrollActivity.class));
            }
        });

        nextenrollmdtBtn = findViewById(R.id.nextenrollmdtBtn);
        nextenrollmdtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!(modalityermbEdit.getText().toString().equals(modalitydao.Select(modalityermbEdit.getText().toString())))){

                    AlertDialog.Builder alert = new AlertDialog.Builder(EnrollModalityActivity.this);
                    alert.setMessage("Modalidade não cadastrada!");
                    alert.setCancelable(true);
                    AlertDialog showAlert = alert.create();
                    showAlert.show();
                }
                else if (!( graduationermbEdit.getText().toString().equals(gradao.Select(graduationermbEdit.getText().toString())))){

                    AlertDialog.Builder alert = new AlertDialog.Builder(EnrollModalityActivity.this);
                    alert.setMessage("Graduação não cadastrada!");
                    alert.setCancelable(true);
                    AlertDialog showAlert = alert.create();
                    showAlert.show();

                }
                else if ((modalityermbEdit.getText().toString() == null) || (graduationermbEdit.getText().toString() == null)
                            || (datestartEdit.getText().toString()==null) || (dateendEdit.getText().toString() == null) || (planEnrollModalityEdit.getText().toString() == null)){

                    AlertDialog.Builder alert = new AlertDialog.Builder(EnrollModalityActivity.this);
                    alert.setMessage("Preencher todos os campos!");
                    alert.setCancelable(true);
                    AlertDialog showAlert = alert.create();
                    showAlert.show();

                }
                else {

                    ModalityEnrollModel model = new ModalityEnrollModel();

                    model.setModality(modalityermbEdit.getText().toString());
                    model.setGraduation(graduationermbEdit.getText().toString());
                    model.setBegin_date((java.sql.Date) new Date(datestartEdit.getText().toString()));
                    model.setEnd_date((java.sql.Date) new Date(dateendEdit.getText().toString()));
                    model.setPlan(planEnrollModalityEdit.getText().toString());

                    modalityenrolldao.Insert(model);

                    startActivity(new Intent(EnrollModalityActivity.this, SingUpActivity.class));
                }
            }
        });
    }
}
