package com.example.martialartacademy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.martialartacademy.database.DAO.StudentDAO;
import com.example.martialartacademy.database.DAO.UserDAO;
import com.example.martialartacademy.database.model.StudentModel;
import com.example.martialartacademy.database.model.UserModel;

public class SingupStudentsActivity extends AppCompatActivity {

    private EditText nameEdit;
    private EditText cpfEdit;
    private EditText birthEdit;
    private EditText emailEdit;
    private EditText phoneEdit;
    private EditText addressEdit;
    private EditText cepEdit;

    private RadioButton maleRadioBtn;
    private RadioButton femaleRadioBtn;
    private Button nextStudentBtn;
    private StudentDAO studentDao;
    private StudentModel student;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup_students);

        studentDao = new StudentDAO(this);
        student = new StudentModel();

        nameEdit = findViewById(R.id.nameEdit);
        cpfEdit = findViewById(R.id.cpfEdit);
        birthEdit = findViewById(R.id.birthEdit);
        emailEdit = findViewById(R.id.emailEdit);
        phoneEdit = findViewById(R.id.phoneEdit);
        addressEdit = findViewById(R.id.addressEdit);
        cepEdit = findViewById(R.id.cepEdit);

        maleRadioBtn = findViewById(R.id.maleRadioBtn);
        maleRadioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                femaleRadioBtn.setFocusable(false);
                student.setGender("Masculino");
            }
        });

        femaleRadioBtn = findViewById(R.id.femaleRadioBtn);
        femaleRadioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                maleRadioBtn.setFocusable(false);
                student.setGender("Feminino");
            }
        });

        nextStudentBtn = findViewById(R.id.nextStudentBtn);
        nextStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cpfEdit.getText().length()!=11){

                    AlertDialog.Builder alert = new AlertDialog.Builder(SingupStudentsActivity.this);
                    alert.setMessage("CPF inválido!");
                    alert.setCancelable(true);
                    AlertDialog showAlert = alert.create();
                    showAlert.show();

                }
                /*if (((nameEdit.getText().toString() && cpfEdit.getText().toString()) == null ){

                }*/

                student.setName(nameEdit.getText().toString());
                student.setCpf(cpfEdit.getText().toString());
                student.setBirth(birthEdit.getText().toString());
                student.getGender();
                student.setEmail(emailEdit.getText().toString());
                student.setPhone(phoneEdit.getText().toString());
                student.setAddress(addressEdit.getText().toString());
                student.setCep(cepEdit.getText().toString());

                //studentDao.Insert(student);

                Toast.makeText(SingupStudentsActivity.this, "Saved!", Toast.LENGTH_LONG).show();

                startActivity(new Intent(SingupStudentsActivity.this, ModalityActivity.class));
            }
        });


    }

}
