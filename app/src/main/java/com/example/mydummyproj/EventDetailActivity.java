package com.example.mydummyproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class EventDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        TextView storyTitle = findViewById(R.id.titleDetail);
        ImageView storyImage = findViewById(R.id.storyImageDetail);

        storyTitle.setText(getIntent().getStringExtra("title"));

        Glide.with(this).load(getIntent().getIntExtra("image",0)).into(storyImage);
    }
}
