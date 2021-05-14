package com.example.martialartacademy;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.martialartacademy.database.DAO.UserDao;

public class LoginActivity extends AppCompatActivity {

    private EditText userEdit;
    private EditText passwordEdit;
    private Button loginBtn;
    private Button singUpBtn;
    private UserDao userDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userDao = new UserDao(this);

        userEdit = findViewById(R.id.userEdit);
        passwordEdit = findViewById(R.id.passwordEdit);

        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userDao.Select(userEdit.getText().toString(), passwordEdit.getText().toString()) !=null){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this, "Login ou senha incorreto!", Toast.LENGTH_LONG).show();
                }
            }
        });

        singUpBtn = findViewById(R.id.singUpBtn);
        singUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
