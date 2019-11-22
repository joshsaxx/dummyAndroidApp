package com.example.mydummyproj;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StoriesTabFragment extends Fragment {


    List <Stories> stories;




    public StoriesTabFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        stories = new ArrayList<>();
        final Stories story = new Stories("Daily Guide", "learns android", R.drawable.dg );
        story.setSubtitle("a subtitle we like");

        stories.add(story);

        final Stories story2 =new Stories("Citi News", "teaches android", R.drawable.citi);
        story2.setSubtitle("another subtitle we like");

        stories.add(story2);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view =  inflater.inflate(R.layout.stories_tab_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        final StoryAdapter stadptr = new StoryAdapter(getContext(), stories);
        recyclerView.setAdapter(stadptr);


        Stories story3 = new Stories("Joy News", "info of new story", R.drawable.joy);
        story3.setSubtitle("subtitle 3");
        stories.add(story3);


        //this function informs the adapter that the list of stories has changed
        stadptr.notifyDataSetChanged();

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,  ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                stories.remove(viewHolder.getAdapterPosition());
                stadptr.notifyItemChanged(viewHolder.getAdapterPosition());

            }
        });

        helper.attachToRecyclerView(recyclerView);


        return view;
    }

}
