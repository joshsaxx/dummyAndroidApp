package com.example.mydummyproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class StudentLogin extends AppCompatActivity  {

    private EditText editTextEmail;
    private EditText editTextPswd;
    private Button loginButton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        loginButton = (Button) findViewById(R.id.loginButton);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);

        editTextPswd = (EditText) findViewById(R.id.editTextPswd);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void showStudentSignup(View view) {
        Intent intent = new Intent(this,StudentSignup.class);
        startActivity(intent);
    }

    public void showStudentHmepage(View view) {
        displayToast("Login Successful!!");
        Intent intent = new Intent(this,StudentHmepage.class);
        startActivity(intent);
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}
