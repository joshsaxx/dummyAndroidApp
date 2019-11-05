package com.example.mydummyproj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    Context context;
    List<Stories> storiesList;

    public StoryAdapter(Context context, List<Stories> storiesListFromSomewhereElse) {
        this.context = context;
        this.storiesList = storiesListFromSomewhereElse;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StoryAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.stories_tab_fragment_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, int position) {
        Stories story = storiesList.get(position);
        holder.title.setText(story.getTitle());
    }

    @Override
    public int getItemCount() {
        return storiesList.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{

        TextView title, subtitle, newstitle;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.subTitle);

            //implement the rest
        }
    }
}
