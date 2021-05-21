package com.example.martialartacademy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.martialartacademy.database.DAO.MobilityDAO;
import com.example.martialartacademy.database.DAO.ModalityDAO;
import com.example.martialartacademy.database.model.ModalityModel;
import com.example.martialartacademy.database.model.StudentModel;

public class ModalityActivity extends AppCompatActivity {

    private EditText modalityEdit;
    private Button backmdlBtn;
    private Button nextmdlBtn;
    private StudentModel student;
    private ModalityModel modality;
    private ModalityDAO moiltyDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modality);

        moiltyDao = new ModalityDAO(this);
        student = new StudentModel();
        modality = new ModalityModel();

        modalityEdit = findViewById(R.id.modalityEdit);
        backmdlBtn = findViewById(R.id.backmdlBtn);
        backmdlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                student.getName();
                student.getCpf();


                startActivity(new Intent(ModalityActivity.this, SingupStudentsActivity.class));

            }
        });

        nextmdlBtn = findViewById(R.id.nextmdlBtn);
        nextmdlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (modalityEdit.getText().toString() == null){

                    AlertDialog.Builder alert = new AlertDialog.Builder(ModalityActivity.this);
                    alert.setMessage("Preencha o campo!");
                    alert.setCancelable(true);
                    AlertDialog showAlert = alert.create();
                    showAlert.show();
                }
                else{

                    modality.setMobility(modalityEdit.getText().toString());
                    moiltyDao.Insert(modality);
                    Toast.makeText(ModalityActivity.this, "Salvo!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(ModalityActivity.this, GraduationActivity.class));

                }
            }
        });
    }
}
