package com.example.martialartacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.martialartacademy.database.model.UserModel;

public class MainActivity extends AppCompatActivity {

    private EditText testEdit;
    private UserModel user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = new UserModel();

        testEdit = findViewById(R.id.testEdit);
        testEdit.setText(user.getNm_user());

    }
}