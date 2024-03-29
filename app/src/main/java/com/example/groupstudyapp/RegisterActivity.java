package com.example.groupstudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private Button CreateAccountButton;
    private EditText UserEmail,UserPassword;
    private TextView AlreadyHaveAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        InitializeFields();
        AlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            SendUserToLoginActivity();
            }
        });
    }

    private void InitializeFields() {
        CreateAccountButton=(Button) findViewById(R.id.register_button);
        UserEmail=(EditText)findViewById(R.id.register_email);
        UserPassword=(EditText) findViewById(R.id.register_password);
        AlreadyHaveAccount=(TextView) findViewById(R.id.already_have_account);
    }
    private void SendUserToLoginActivity() {
        Intent loginIntent=new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(loginIntent);
    }
}