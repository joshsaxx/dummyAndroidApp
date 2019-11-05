package com.example.mydummyproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FacultyLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_login);
    }

    public void showFacultyHmepage(View view) {
        Intent intent = new Intent(this,FacultyHmepage.class);
        startActivity(intent);
    }
}
