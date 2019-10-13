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

public class CreateProfileActivity extends AppCompatActivity {


    EditText name, email, age, location, qualification, gpa;
    Button create;
    RadioButton m, f, o;
    Spinner spinner;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprofile);

        databaseReference = FirebaseDatabase.getInstance().getReference("candidates");


        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        age = findViewById(R.id.age);
        location = findViewById(R.id.location);
        qualification = findViewById(R.id.qualification);
        gpa = findViewById(R.id.gpa);


        create = findViewById(R.id.create);
        m = findViewById(R.id.radioButton1);
        f = findViewById(R.id.radioButton2);
        o = findViewById(R.id.radioButton3);


        spinner = (Spinner) findViewById(R.id.spinner);






        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();

            name.setText(personName);
            email.setText(personEmail);
        }

        create.setOnClickListener(v -> create());
    }

    private void create() {


        String sname,sage,semail,slocaion,squalification,sgpa,sspecialization;
        int sgender;
        sname = name.getText().toString();
        sage = age.getText().toString();
        semail = email.getText().toString();
        slocaion = location.getText().toString();
        squalification = qualification.getText().toString();
        sgpa = gpa.getText().toString();

        if(m.isChecked())
          sgender = 1;
        else if(f.isChecked())
            sgender = 2;
        else
            sgender =3;

        String spin = spinner.getSelectedItem().toString();


        if(!TextUtils.isEmpty(sgpa)){
          String id = databaseReference.push().getKey();

          Candidate candidate = new Candidate(sname,semail,sage,slocaion,squalification,sgpa,sgender,spin);
          databaseReference.child(id).setValue(candidate);
          Toast.makeText(this,"Created",Toast.LENGTH_SHORT).show();
            adddata();
        }else{

            Toast.makeText(this,"Fields cannot be left empty",Toast.LENGTH_SHORT).show();
        }


    }

    private void adddata() {



        Intent intent = new Intent(getApplicationContext(), JobsActivity.class);
        startActivity(intent);
    }
}
