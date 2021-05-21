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
import com.example.martialartacademy.database.DAO.PlanDAO;
import com.example.martialartacademy.database.model.PlanModel;

import java.math.BigDecimal;

public class PlanActivity extends AppCompatActivity {

    private EditText modalityPlnEdit;
    private EditText planEdit;
    private EditText monthlyValueEdit;

    private Button backplnBtn;
    private  Button  nextplnBtn;

    private ModalityDAO modalitydao;
    private PlanDAO plandao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        plandao = new PlanDAO(this);
        modalitydao = new ModalityDAO(this);

        modalityPlnEdit = findViewById(R.id.modalityPlnEdit);
        planEdit= findViewById(R.id.planEdit);
        monthlyValueEdit = findViewById(R.id.monthlyValueEdit);

        backplnBtn = findViewById(R.id.backplnBtn);
        backplnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(PlanActivity.this, GraduationActivity.class));

            }
        });

        nextplnBtn = findViewById(R.id.nextplnBtn);
        nextplnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!(modalitydao.Select(modalityPlnEdit.getText().toString()).equals(modalityPlnEdit.getText().toString()))  ){

                    AlertDialog.Builder alert = new AlertDialog.Builder(PlanActivity.this);
                    alert.setMessage("Modalidade não cadastrada!");
                    alert.setCancelable(true);
                    AlertDialog showAlert = alert.create();
                    showAlert.show();
                }
                else if ((modalityPlnEdit.getText().toString()==null) || (planEdit.getText().toString() ==null) || (monthlyValueEdit.getText().toString() == null)){

                    AlertDialog.Builder alert = new AlertDialog.Builder(PlanActivity.this);
                    alert.setMessage("Os campos devem estar todos preenchidos!");
                    alert.setCancelable(true);
                    AlertDialog showAlert = alert.create();
                    showAlert.show();
                }
                else {

                    PlanModel plan = new PlanModel();

                    plan.setModality(modalityPlnEdit.getText().toString());
                    plan.setPlan(planEdit.getText().toString());
                    plan.setMonthlyvalue(BigDecimal.valueOf(Long.parseLong(modalityPlnEdit.getText().toString())));

                    plandao.Insert(plan);
                    startActivity(new Intent(PlanActivity.this, EnrollActivity.class));

                }
            }
        });
    }
}
