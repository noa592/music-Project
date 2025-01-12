package com.example.noa_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class NewAccountActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    Button btnRegister, btnLogin;
    EditText etEmailAddress, etNumberPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account_activity);
    }
}