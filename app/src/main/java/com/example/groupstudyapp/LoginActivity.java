package com.example.groupstudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.mbms.MbmsErrors;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseUser currentUser;
    private Button LoginButton,PhoneLoginButton;
    private EditText UserEmail,UserPassword;
    private TextView NeedNewAccountLink,ForgetPasswordLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InitilalizeFields();
        NeedNewAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendUserToRegisterActivity();
            }
        });
    }

    private void InitilalizeFields() {
        LoginButton=(Button) findViewById(R.id.login_button);
        PhoneLoginButton=(Button) findViewById(R.id.phone_login_button);
        UserEmail=(EditText) findViewById(R.id.login_email);
        UserPassword=(EditText) findViewById(R.id.login_password);
        NeedNewAccountLink=(TextView) findViewById(R.id.need_new_account);
        ForgetPasswordLink=(TextView) findViewById(R.id.forget_password_link);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(currentUser!=null){
           SendUserToMainActivity();
        }
    }

    private void SendUserToMainActivity() {
        Intent loginIntent=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(loginIntent);
    }
    private void SendUserToRegisterActivity() {
        Intent registerIntent=new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(registerIntent);
    }
}