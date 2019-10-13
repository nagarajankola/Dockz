package com.inferno.dockz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class JobAdapter extends RecyclerView.Adapter<JobAdapter.ViewHolder> {
        Context mCtx;
        List<Job> jobList;

public JobAdapter(Context mCtx, List<Job> jobList) {
        this.mCtx = mCtx;
        this.jobList = jobList;
        }

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.item_job,
        parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
        }

@Override
public void onBindViewHolder(ViewHolder holder, int position) {


        Job job = jobList.get(position);
        holder.pos.setText(job.getPosition());
        holder.org.setText(job.getOrg());
        holder.loc.setText(job.getLoc());
        holder.sal.setText(job.getSal());
        holder.desc.setText(job.getDescription());

        }

@Override
public int getItemCount() {
        return jobList.size();
        }

class ViewHolder extends RecyclerView.ViewHolder {

    TextView pos,org,loc,sal,desc;

    public ViewHolder(View itemView) {
        super(itemView);

        pos = itemView.findViewById(R.id.position);
        org = itemView.findViewById(R.id.org);
        loc = itemView.findViewById(R.id.location);
        desc = itemView.findViewById(R.id.desc);
        sal = itemView.findViewById(R.id.sal);


    }
}
}