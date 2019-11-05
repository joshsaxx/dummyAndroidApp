package com.example.mydummyproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ClubheadLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubhead_login);
    }

    public void showClubheadHomepage(View view) {
        Intent intent = new Intent(this, ClubheadHomepage.class);
        startActivity(intent);
    }
}
