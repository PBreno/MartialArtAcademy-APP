package com.example.martialartacademy;

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
    private UserDAO userDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup_students);

        userDao = new UserDAO(this);

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
                String male = null;


            }
        });

        femaleRadioBtn = findViewById(R.id.femaleRadioBtn);
        femaleRadioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        nextStudentBtn = findViewById(R.id.nextStudentBtn);
        nextStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StudentModel user = new StudentModel();

                if (cpfEdit.getText().length()<11){

                    AlertDialog.Builder alert = new AlertDialog.Builder(SingupStudentsActivity.this);
                    alert.setMessage("Login ou senha incorreto!");
                    alert.setCancelable(true);
                    AlertDialog showaler = alert.create();
                    showaler.show();

                }
                /*if (((nameEdit.getText().toString() && cpfEdit.getText().toString()) == null ){

                }*/

                user.setName(nameEdit.getText().toString());
                user.setCpf(cpfEdit.getText().toString());
                user.setBirth(birthEdit.getText().toString());
                user.setEmail(emailEdit.getText().toString());
                user.setPhone(phoneEdit.getText().toString());
                user.setAddress(addressEdit.getText().toString());
                user.setCep(cepEdit.getText().toString());

                Toast.makeText(SingupStudentsActivity.this, "Saved!", Toast.LENGTH_LONG).show();
            }
        });


    }

}
