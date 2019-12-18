package com.example.mydummyproj;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder>{


    private static final String TAG = "JobAdapter";
    ArrayList<Jobs> jobsList;
    Context mContext;

    public JobAdapter(ArrayList<Jobs> jobsList, Context mContext) {
        this.jobsList = jobsList;
        this.mContext = mContext;

        Log.d(TAG, "JobAdapter: "+jobsList.get(0).getTitle());
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new JobViewHolder(LayoutInflater.from(mContext).inflate(R.layout.activity_alumini_homepage_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        Jobs jobs = jobsList.get(position);
        holder.jobTitle.setText(jobs.getTitle());
        holder.jobLocation.setText(jobs.getLocation());
        holder.jobType.setText(jobs.getType());
        holder.companyName.setText(jobs.getCompany());
        holder.dateCreated.setText(jobs.getCreated_at());

        Log.d(TAG, "onBindViewHolder: ");

    }

    @Override
    public int getItemCount() {
        return jobsList.size();
    }

    public class JobViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView jobTitle, jobLocation, jobType, companyName, dateCreated;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);

            jobTitle = itemView.findViewById(R.id.textViewJobTitle);
            jobLocation = itemView.findViewById(R.id.textViewJobLocation);
            jobType = itemView.findViewById(R.id.textViewJobType);
            companyName = itemView.findViewById(R.id.textViewCompanyName);
            dateCreated = itemView.findViewById(R.id.textViewDateCreated);

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            Jobs jobs = jobsList.get(getAdapterPosition());
            Intent detailIntent = new Intent(mContext,JobDetailActivity.class);
            detailIntent.putExtra("jobType",jobs.getType());
            detailIntent.putExtra("jobLocation",jobs.getLocation());
            detailIntent.putExtra("jobTitle",jobs.getTitle());
            detailIntent.putExtra("jobDescription",jobs.getDescription());

            detailIntent.setFlags(FLAG_ACTIVITY_NEW_TASK);

            mContext.startActivity(detailIntent);

            Log.d(TAG, "onClick: ");
        }
    }
}
