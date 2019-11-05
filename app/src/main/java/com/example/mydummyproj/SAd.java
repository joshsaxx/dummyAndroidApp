package com.example.mydummyproj;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

class SAd extends RecyclerView.ViewHolder {

    // Member Variables for the TextViews
    private TextView mTitleText;
    private TextView mInfoText;
    private ImageView mSportsImage;

    /**
     * Constructor for the ViewHolder, used in onCreateViewHolder().
     *
     * @param itemView The rootview of the list_item.xml layout file.
     */
    SAd(View itemView) {
        super(itemView);

        // Initialize the views.
        mTitleText = itemView.findViewById(R.id.title);
        mInfoText = itemView.findViewById(R.id.subTitle);
        mSportsImage = itemView.findViewById(R.id.sportsImage);
    }

    void bindTo(Sport currentSport){
        // Populate the textviews with data.
        mTitleText.setText(currentSport.getTitle());
        mInfoText.setText(currentSport.getInfo());
        //Glide.with(mContext).load(currentSport.getResourceId()).into(mSportsImage);

    }
}
