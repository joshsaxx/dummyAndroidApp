package com.example.mydummyproj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class EventAdapter  extends RecyclerView.Adapter<EventVHclass.EventViewholder> {

    List<Events> eventsList;
    Context context;


    public EventAdapter(Context context, List<Events> eventsLists) {
        this.context = context;
        this.eventsList = eventsLists;
    }

    @NonNull
    @Override
    public EventVHclass.EventViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EventVHclass.EventViewholder(LayoutInflater.from(context).inflate(R.layout.events_tab_fragment_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventVHclass.EventViewholder holder, int position) {
        Events events = eventsList.get(position);
        holder.title.setText(events.getTitle());
        holder.subtitle.setText(events.getSubtitle());
        //holder.image, story.getImageID() for glide
        Glide.with(context).load(events.getImageID()).into(holder.image);
    }

    /**@Override
    public void onBindViewHolder(@NonNull EventAdapter.EventViewholder holder, int position) {
        Events events = eventsList.get(position);
        holder.title.setText(events.getTitle());
        holder.subtitle.setText(events.getSubtitle());
        //holder.image, story.getImageID() for glide
        Glide.with(context).load(events.getImageID()).into(holder.image);

    }*/

    @Override
    public int getItemCount() {
        return eventsList.size();
    }


}
