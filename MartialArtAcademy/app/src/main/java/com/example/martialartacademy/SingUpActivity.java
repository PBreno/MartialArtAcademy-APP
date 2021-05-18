package com.example.martialartacademy;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.martialartacademy.database.DAO.UserDao;

public class SingUpActivity extends AppCompatActivity {

    private EditText nameEdit;
    private EditText cpfEdit;
    private EditText birthEdit;
    private EditText emailEdit;
    private EditText phoneEdit;
    //private EditText emailEdit;
    private EditText usernameEdit;
    private EditText passwordEdit;
    private EditText confirmpswEdit;

    private Button maleRadioBtn;
    private Button femaleRadioBtn;
    private UserDao userDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup_students);

        userDao = new UserDao(this);

        nameEdit = findViewById(R.id.nameEdit);
        cpfEdit = findViewById(R.id.cpfEdit);
        birthEdit = findViewById(R.id.birthEdit);
        emailEdit = findViewById(R.id.emailEdit);
        phoneEdit = findViewById(R.id.phoneEdit);
        usernameEdit = findViewById(R.id.usernameEdit);
        passwordEdit = findViewById(R.id.passwordEdit);
        confirmpswEdit = findViewById(R.id.confirmpswEdit);

    }
}
