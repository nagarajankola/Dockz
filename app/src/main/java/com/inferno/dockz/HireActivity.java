package com.inferno.dockz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HireActivity extends AppCompatActivity {
    EditText designation, org,location,salary,desc;
    Button post;
    Spinner spinner;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire);

        databaseReference = FirebaseDatabase.getInstance().getReference("jobs");


        designation = findViewById(R.id.designation);
        org = findViewById(R.id.org);
        location = findViewById(R.id.loc);
        salary = findViewById(R.id.sal);
        desc = findViewById(R.id.desc);


        post = findViewById(R.id.post);
        spinner = (Spinner) findViewById(R.id.spinner);






        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if (acct != null) {
            /*String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();

            name.setText(personName);
            email.setText(personEmail);*/
        }

        post.setOnClickListener(v -> post());
    }

    private void post() {


        String sdes,sorg,sloc,ssal,sdesc;

        sdes = designation.getText().toString();
        sorg = org.getText().toString();
        sloc = location.getText().toString();
        ssal = salary.getText().toString();
        sdesc = desc.getText().toString();



        String spin = spinner.getSelectedItem().toString();


        if(!TextUtils.isEmpty(ssal)){
            String id = databaseReference.push().getKey();

            Job job = new Job(sdes,sorg,sdesc,ssal,sloc,spin);
            databaseReference.child(id).setValue(job);
            Toast.makeText(this,"Posted",Toast.LENGTH_SHORT).show();
            adddata();
        }else{

            Toast.makeText(this,"Fields cannot be left empty",Toast.LENGTH_SHORT).show();
        }


    }

    private void adddata() {



        Intent intent = new Intent(getApplicationContext(), CandidateActivity.class);
        startActivity(intent);
    }
}
