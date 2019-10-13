package com.inferno.dockz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.FragmentManager;
import android.os.Bundle;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CandidateActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CandidateAdapter adapter;
    List<Candidate> candidateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);

        recyclerView = findViewById(R.id.candidates);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        candidateList = new ArrayList<>();

        DatabaseReference dbProducts = FirebaseDatabase.getInstance().getReference("candidates");

        dbProducts.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){

                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                        Candidate p = snapshot.getValue(Candidate.class);
                        candidateList.add(p);
                    }

                    adapter = new CandidateAdapter(CandidateActivity.this, candidateList);
                    recyclerView.setAdapter(adapter);


                }

            }




            

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }
}