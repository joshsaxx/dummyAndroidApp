package com.example.mydummyproj;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
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
public class EventsTabFragment extends Fragment {

    List<Events> events;


    public EventsTabFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        events = new ArrayList<>();
        Events event = new Events("learns android", R.drawable.panafestemancipation);
        event.setSubtitle("Panafest & Emancipation");

        events.add(event);

        Events event2 =new Events( "teaches android", R.drawable.africa_e1557848201529);
        event2.setSubtitle("Back to Africa: Two Cultures One Foundation");

        events.add(event2);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.events_tab_fragment, container, false);
        View view =  inflater.inflate(R.layout.events_tab_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        final EventAdapter stadptr = new EventAdapter(getContext(), events);
        recyclerView.setAdapter(stadptr);


        Events event3 = new Events( "info of new story", R.drawable.img5d8362503adfc);
        event3.setSubtitle("Year of Return 2019");
        events.add(event3);


        //this function informs the adapter that the list of stories has changed
        stadptr.notifyDataSetChanged();

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                events.remove(viewHolder.getAdapterPosition());
                stadptr.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        helper.attachToRecyclerView(recyclerView);
        return view;
    }

}
