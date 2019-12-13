package com.example.mydummyproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JobDetailActivity extends AppCompatActivity {

   //private GitHubJobsApi gitHubJobsApi;
    EditText editTextSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);

        TextView jobType = findViewById(R.id.textViewJobType);
        TextView jobLocation = findViewById(R.id.textViewJobLocation);
        TextView jobTitle = findViewById(R.id.textViewJobTitle);
        TextView jobDescription = findViewById(R.id.textViewJobDescription);
        editTextSearch = findViewById(R.id.editTextSearch);

        ImageButton searchButton = findViewById(R.id.imageButtonSearch);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = editTextSearch.getText().toString();
            }
        });
        /*editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });*/

        jobType.setText(getIntent().getStringExtra("jobType"));
        jobLocation.setText(getIntent().getStringExtra("jobLocation"));
        jobTitle.setText(getIntent().getStringExtra("jobTitle"));
        jobDescription.setText(getIntent().getStringExtra("jobDescription"));
    }

   /* private void filter(String text){
        //ArrayList<Jobs> jobs = new ArrayList<>();



    }*/
}
