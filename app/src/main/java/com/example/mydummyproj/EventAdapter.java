package com.example.mydummyproj;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class EventAdapter  extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    List<Events> eventsList;
    Context context;


    public EventAdapter(Context context, List<Events> eventsLists) {
        this.context = context;
        this.eventsList = eventsLists;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EventViewHolder(LayoutInflater.from(context).inflate(R.layout.events_tab_fragment_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Events events = eventsList.get(position);
        holder.title.setText(events.getTitle());
        holder.subtitle.setText(events.getSubtitle());
        //holder.image, story.getImageID() for glide
        Glide.with(context).load(events.getImageID()).into(holder.image);
    }

   /** @Override
    public void onBindViewHolder(@NonNull EventVHclass holder, int position) {
        Events events = eventsList.get(position);
        holder.title.setText(events.getTitle());
        holder.subtitle.setText(events.getSubtitle());
        //holder.image, story.getImageID() for glide
        Glide.with(context).load(events.getImageID()).into(holder.image);
    }*/

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

    class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title, subtitle, newstitle;
        ImageView image;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.subTitle);
            image = itemView.findViewById(R.id.eventImage);

            itemView.setOnClickListener(this);
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



}
