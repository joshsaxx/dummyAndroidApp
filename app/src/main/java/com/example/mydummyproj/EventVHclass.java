package com.example.mydummyproj;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventVHclass extends RecyclerView.ViewHolder {


    TextView title, subtitle, newstitle;
    ImageView image;


    public EventVHclass(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.title);
        subtitle = itemView.findViewById(R.id.subTitle);
        image = itemView.findViewById(R.id.eventImage);
    }
}