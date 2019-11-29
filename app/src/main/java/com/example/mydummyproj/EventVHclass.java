package com.example.mydummyproj;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventVHclass extends RecyclerView.ViewHolder implements View.OnClickListener{


    List<Events> eventsList;
    Context context;


    TextView title, subtitle, newstitle;
    ImageView image;


    public EventVHclass(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.title);
        subtitle = itemView.findViewById(R.id.subTitle);
        image = itemView.findViewById(R.id.eventImage);
    }

    @Override
    public void onClick(View v) {
        Events events = eventsList.get(getAdapterPosition());
        Intent detailIntent = new Intent(context, EventDetailActivity.class);
        detailIntent.putExtra("title", events.getTitle());
        detailIntent.putExtra("image", events.getImageID());
        context.startActivity(detailIntent);
    }
}