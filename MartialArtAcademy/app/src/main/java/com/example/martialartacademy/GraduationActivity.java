package com.example.martialartacademy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.martialartacademy.database.DAO.GraduationDAO;
import com.example.martialartacademy.database.DAO.ModalityDAO;
import com.example.martialartacademy.database.model.GraduationModel;
import com.example.martialartacademy.database.model.ModalityModel;

import java.util.ArrayList;

public class GraduationActivity extends AppCompatActivity {

    private EditText modalityGraEdit;
    private EditText graduationEdit;

    private Button backgrdBtn;
    private Button nextgrdBtn;
    private ModalityDAO modalitydao;
    private GraduationDAO gradao;
    private ArrayList<ModalityModel> arlmoda;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graduation);

        gradao = new GraduationDAO(this);
        modalitydao = new ModalityDAO(this);

        modalityGraEdit = findViewById(R.id.modalityEdit);
        graduationEdit = findViewById(R.id.graduationEdit);

        backgrdBtn = findViewById(R.id.backgrdBtn);
        backgrdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(GraduationActivity.this, ModalityActivity.class));
            }
        });

        nextgrdBtn = findViewById(R.id.nextgrdBtn);
        nextgrdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                arlmoda = new ArrayList<>();

                if (!(modalitydao.Select(modalityGraEdit.getText().toString()).equals(modalityGraEdit.getText().toString()))  ){

                    AlertDialog.Builder alert = new AlertDialog.Builder(GraduationActivity.this);
                    alert.setMessage("Modalidade não cadastrada!");
                    alert.setCancelable(true);
                    AlertDialog showAlert = alert.create();
                    showAlert.show();
                }
                else if ((modalityGraEdit.getText().toString() == null) || (graduationEdit.getText().toString() == null)){

                    AlertDialog.Builder alert = new AlertDialog.Builder(GraduationActivity.this);
                    alert.setMessage("Preencher todos os campos!");
                    alert.setCancelable(true);
                    AlertDialog showAlert = alert.create();
                    showAlert.show();
                }
               /* else if (graduationEdit.getText().toString().equals(gradao.Select(graduationEdit.getText().toString()))){
                    AlertDialog.Builder alert = new AlertDialog.Builder(GraduationActivity.this);
                    alert.setMessage("Modalidade j!");
                    alert.setCancelable(true);
                    AlertDialog showAlert = alert.create();
                    showAlert.show();
                }*/
                else{

                    GraduationModel model = new GraduationModel();

                    model.setModality(modalityGraEdit.getText().toString());
                    model.setGraduation(graduationEdit.getText().toString());

                    gradao.Insert(model);

                    startActivity(new Intent(GraduationActivity.this, PlanActivity.class));

                }
            }
        });
    }
}
