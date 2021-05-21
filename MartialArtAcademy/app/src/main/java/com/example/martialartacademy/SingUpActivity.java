package com.example.martialartacademy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.martialartacademy.database.DAO.UserDAO;
import com.example.martialartacademy.database.model.UserModel;

public class SingUpActivity extends AppCompatActivity {

    private EditText usernameEdit;
    private EditText passwordEdit;
    private EditText confirmpswEdit;

    private Button saveBtn;
    private Button backloginBtn;
    private UserDAO userDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup_students);

        userDao = new UserDAO(this);

        usernameEdit = findViewById(R.id.usernameEdit);
        passwordEdit = findViewById(R.id.passwordEdit);
        confirmpswEdit = findViewById(R.id.confirmpswEdit);

        backloginBtn = findViewById(R.id.backloginBtn);
        backloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SingUpActivity.this, EnrollModalityActivity.class));
            }
        });

        saveBtn= findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (passwordEdit.getText().toString().equals(confirmpswEdit.getText().toString())){

                    UserModel user = new UserModel();

                    user.setNm_user(usernameEdit.getText().toString());
                    user.setDs_password(passwordEdit.getText().toString());

                    if (userDao.Insert(user) > 0){
                        finish();
                    }

                }
                else{

                    AlertDialog.Builder alert = new AlertDialog.Builder(SingUpActivity.this);
                    alert.setMessage("As senhas têm que ser iguais!");
                    alert.setCancelable(true);
                    AlertDialog aler = alert.create();
                    aler.show();

                }

            }
        });
    }
}
