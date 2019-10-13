package com.inferno.dockz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class CandidateAdapter extends RecyclerView.Adapter<CandidateAdapter.ViewHolder> {
    Context mCtx;
    List<Candidate> candidateList;

    public CandidateAdapter(Context mCtx, List<Candidate> candidateList) {
        this.mCtx = mCtx;
        this.candidateList = candidateList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.item_candidate,
                parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        Candidate candidate = candidateList.get(position);
        holder.name.setText(candidate.getName());
        holder.email.setText(candidate.getEmail());
        holder.age.setText(candidate.getAge());
        holder.loc.setText(candidate.getLocation());
        holder.qual.setText(candidate.getQualification());
        holder.gpa.setText(candidate.getGpa());
        holder.spec.setText(candidate.getSpecialization());


    }

    @Override
    public int getItemCount() {
        return candidateList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,email,age,loc,qual,gpa,spec;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            age =itemView.findViewById(R.id.age);
            loc = itemView.findViewById(R.id.location);
            qual = itemView.findViewById(R.id.qualification);
            gpa = itemView.findViewById(R.id.gpa);
            spec = itemView.findViewById(R.id.specialization);



        }
    }
}