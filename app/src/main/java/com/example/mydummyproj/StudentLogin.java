package com.example.mydummyproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class StudentLogin extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail;
    private EditText editTextPswd;
    private ProgressBar progressBar;


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);


        editTextEmail = (EditText) findViewById(R.id.editTextEmail);

        editTextPswd = (EditText) findViewById(R.id.editTextPswd);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        findViewById(R.id.loginButton).setOnClickListener(this);
        findViewById(R.id.signupButton).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void userSignin(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPswd.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError("email required");
            editTextEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editTextPswd.setError("password required");
            editTextPswd.requestFocus();
            return;
        }
        if (password.length() < 8) {
            editTextPswd.setError("Password must be at least 8 characters long");
            editTextPswd.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()){
                    Intent intent = new Intent(StudentLogin.this, StudentHmepage.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    /**public void showStudentSignup(View view) {
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
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                userSignin();
                break;
        }
        switch (v.getId()) {
            case R.id.signupButton:
                startActivity(new Intent(this,StudentSignup.class));
                break;
        }
    }
}
