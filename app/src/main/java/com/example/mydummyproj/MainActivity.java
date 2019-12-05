package com.example.mydummyproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showStudentLogin(View view) {
        Intent intent = new Intent(this,StudentLogin.class);
        startActivity(intent);

    }

    public void showFacultyLogin(View view) {
        Intent intent = new Intent(this,FacultyLogin.class);
        startActivity(intent);
    }

    public void showClubheadLogin(View view) {
        Intent intent = new Intent(this,ClubheadLogin.class);
        startActivity(intent);
    }

    public void showAluminiHomepage(View view) {
        Intent intent = new Intent(this,AluminiHomepage.class);
        startActivity(intent);
    }


}
