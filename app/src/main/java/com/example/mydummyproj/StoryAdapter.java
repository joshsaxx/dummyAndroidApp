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

class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {

    //this is the context to enable us obtain the layout inflater
    Context context;
    //this is the list of similar objects to populate our list view
    List<Stories> storiesList;

    //constructor to obtain our context and list of stories from our activity
    public StoryAdapter(Context context, List<Stories> storiesListFromSomewhereElse) {
        // this context variable (from inside this class) is assigned the value of context that is passed from our constructor
        this.context = context;
        this.storiesList = storiesListFromSomewhereElse;
    }



    //create a viewholder which represents the view of the various items in our storiesList
    //we do this by inflating a layout using the LayoutInflater class
    //we need the context passed in the constructor, and the item layout for a story
    @NonNull
    @Override
    public StoryAdapter.StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StoryAdapter.StoryViewHolder(LayoutInflater.from(context).inflate(R.layout.stories_tab_fragment_item, parent, false));
    }

    //this method helps us to bind each storyitemviewholder with its corresponding story item from the list
    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.StoryViewHolder holder, int position) {
        Stories story = storiesList.get(position);
        holder.title.setText(story.getTitle());
        holder.subtitle.setText(story.getSubtitle());
        //holder.image, story.getImageID() for glide
        Glide.with(context).load(story.getImageID()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return storiesList.size();
    }



    //this is a class for the view of a single story item
    //it must extend RecyclerView.ViewHolder because it is a viewholder
    class StoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{



        //we need to create parameters, for each of the component views of the story item
        TextView title, subtitle, newstitle;
        ImageView image;

        //the constructor is already defined for us
        //we need to pass it a view when we call oncreateviewholder
        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.subTitle);
            image = itemView.findViewById(R.id.storyImage);

            itemView.setOnClickListener(this);

            //implement the rest
        }

        @Override
        public void onClick(View v) {

            Intent detailIntent = new Intent(context, StoryDetailActivity.class);




        }
    }
}
