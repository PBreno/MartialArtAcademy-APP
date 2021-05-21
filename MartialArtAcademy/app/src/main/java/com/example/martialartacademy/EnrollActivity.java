package com.example.martialartacademy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.martialartacademy.database.DAO.EnrollDAO;
import com.example.martialartacademy.database.DAO.StudentDAO;
import com.example.martialartacademy.database.model.EnrollModel;
import com.example.martialartacademy.database.model.StudentModel;

import java.util.Date;

public class EnrollActivity extends AppCompatActivity {

    private EditText  studentIDEdit;
    private EditText enrolldateEdit;
    private EditText expireddateEdit;
    private EditText closingdateEdit;

    private Button backenrollBtn;
    private Button nextenrollBtn;
    private StudentModel studentdao;
    private EnrollDAO enrolldao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll);

        studentdao = new StudentModel();
        enrolldao = new EnrollDAO(this);

        studentIDEdit = findViewById(R.id.studentIDEdit);
        enrolldateEdit= findViewById(R.id.studentIDEdit);
        expireddateEdit = findViewById(R.id.expireddateEdit);
        closingdateEdit = findViewById(R.id.closingdateEdit);

        backenrollBtn = findViewById(R.id.backenrollBtn);
        backenrollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(EnrollActivity.this, PlanActivity.class));
            }
        });
        nextenrollBtn = findViewById(R.id.nextenrollBtn);
        nextenrollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!(studentIDEdit.getText().toString()).equals(studentdao.getId())){

                    AlertDialog.Builder alert = new AlertDialog.Builder(EnrollActivity.this);
                    alert.setMessage("ID aluno não encontrado!");
                    alert.setCancelable(true);
                    AlertDialog showAlert = alert.create();
                    showAlert.show();
                }
                else if ((studentIDEdit.getText().toString() == null) || (enrolldateEdit.getText().toString() == null)
                            ||(expireddateEdit.getText().toString() == null) || (closingdateEdit.getText().toString() == null)){

                    AlertDialog.Builder alert = new AlertDialog.Builder(EnrollActivity.this);
                    alert.setMessage("ID aluno não encontrado!");
                    alert.setCancelable(true);
                    AlertDialog showAlert = alert.create();
                    showAlert.show();

                }
                else {

                    EnrollModel enroll = new EnrollModel();

                    enroll.setStudent_id(Integer.valueOf(studentIDEdit.getText().toString()));
                    enroll.setEnroll_date((new Date(enrolldateEdit.toString())));
                    enroll.setExpired_day(Integer.valueOf(expireddateEdit.getText().toString()));
                    enroll.setClosing_date(new Date(closingdateEdit.getText().toString()));

                    enrolldao.Insert(enroll);

                    startActivity(new Intent(EnrollActivity.this, EnrollModalityActivity.class));
                }
            }
        });

    }
}
