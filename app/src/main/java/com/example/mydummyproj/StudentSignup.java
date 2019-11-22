package com.example.mydummyproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import java.util.Arrays;
import java.util.List;

public class StudentSignup extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextName,editTextRollNum,editTextPhone,editTextEmail,editTextPswd,editTextConfPswd;
    //private Spinner yearSpinner,branchSpinner,collegeSpinner;

    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_signup);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextRollNum = (EditText) findViewById(R.id.editTextRollNum);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPswd = (EditText) findViewById(R.id.editTextPswd);
        editTextConfPswd = (EditText) findViewById(R.id.editTextConfPswd);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        //collegeSpinner = (Spinner) findViewById(R.id.collegeSpinner);
        //branchSpinner = (Spinner) findViewById(R.id.branchSpinner);
        //yearSpinner = (Spinner) findViewById(R.id.yearSpinner);

        findViewById(R.id.signupButton).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

    }


    public void registerUser(){
        String name = editTextName.getText().toString().trim();
        String rollNum = editTextRollNum.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPswd.getText().toString().trim();
        String confirmPassword = editTextConfPswd.getText().toString().trim();

        //List<String> college = Arrays.asList(getResources().getStringArray(R.array.collegeSpinner_items));

        if (name.isEmpty()){
            editTextName.setError("Name required");
            editTextName.requestFocus();
            return;
        }
        if (rollNum.isEmpty()){
            editTextRollNum.setError("Roll Number required");
            editTextRollNum.requestFocus();
            return;
        }
        if (phone.isEmpty()){
            editTextPhone.setError("Phone required");
            editTextPhone.requestFocus();
            return;
        }

        if (email.isEmpty()){
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

        if (confirmPassword.isEmpty()){
            editTextConfPswd.setError("Confirm Password");
            editTextConfPswd.requestFocus();
            return;
        }

        if (password.equals(confirmPassword)){

            progressBar.setVisibility(View.VISIBLE);
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"User Registered Successfully.",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(StudentSignup.this, StudentHmepage.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else {
                    //Toast.makeText(getApplicationContext(),"User Registration Failed!",Toast.LENGTH_SHORT).show();

                    if (task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"User Already Exists!!",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }else{
            Toast.makeText(getApplicationContext(), "Passwords do not match!! Try again.",Toast.LENGTH_SHORT).show();
        }
    }

    /**public void showStudentLogin(View view) {
        displayToast("Sign Up Successful!!");
        Intent intent = new Intent(this,StudentLogin.class);
        startActivity(intent);

    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.signupButton:
                registerUser();
                break;

        }

    }
}
