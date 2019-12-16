package com.example.mydummyproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AluminiHomepage extends AppCompatActivity {


    //private TextView textViewResult;
    private static final String TAG = "AluminiHomepage";
    private GitHubJobsApi gitHubJobsApi;
    private ArrayList<Jobs> jobsArrayList;
    private RecyclerView recyclerView;
    private JobAdapter jobAdapter;
    private EditText editTextSearch;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumini_homepage);

        Toast.makeText(AluminiHomepage.this, "Please Click Button to Display Jobs",Toast.LENGTH_SHORT).show();

        jobsArrayList = new ArrayList<Jobs>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        editTextSearch = findViewById(R.id.editTextSearch);
        ImageButton searchButton = findViewById(R.id.imageButtonSearch);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick: we have clicked");
                getJobTxt();
                Toast.makeText(AluminiHomepage.this, "Getting Jobs",Toast.LENGTH_SHORT).show();
                getJobs(editTextSearch.getText().toString());
            }
        });

        //textViewResult = findViewById(R.id.textView_result);

       Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jobs.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        gitHubJobsApi = retrofit.create(GitHubJobsApi.class);

        //jobAdapter = new JobAdapter(new ArrayList<Jobs>(), this);



    }

    private void getJobTxt(){
        String msg = editTextSearch.getText().toString();
        Log.d(TAG, "getJobTxt: "+msg);
    }

    private void getJobs(String filter) {

        Call<List<Jobs>> call = gitHubJobsApi.getJobs(filter);

        call.enqueue(new Callback<List<Jobs>>() {


            @Override
            public void onResponse(Call<List<Jobs>> call, Response<List<Jobs>> response) {
                /*if (!response.isSuccessful()){
                    //textViewResult.setText("Code: " +response.code());
                    return;
                }*/
                List<Jobs> jobsx= response.body();
                jobsArrayList = new ArrayList<>();
                jobsArrayList.addAll(jobsx);
                //Log.d(TAG, jobsArrayList.get(0).getTitle());

                jobAdapter = new JobAdapter(jobsArrayList, getBaseContext());

                recyclerView.setAdapter(jobAdapter);

                jobAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Jobs>> call, Throwable t) {
                //textViewResult.setText(t.getMessage());

                Toast.makeText(AluminiHomepage.this, "Error occurred",Toast.LENGTH_SHORT).show();

            }
        });
    }

    //String message = mMessageEditText.getText().toString();
    /*button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(editText.getText().toString());
        }*/
}
