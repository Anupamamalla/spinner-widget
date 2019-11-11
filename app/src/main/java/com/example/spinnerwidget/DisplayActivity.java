package com.example.spinnerwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {

    TextView myName,myPhone,myEmail,myGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        myName = findViewById(R.id.myName);

        myPhone= findViewById(R.id.phone);

        myEmail = findViewById(R.id.mail);

        myGender = findViewById(R.id.gender);



        Bundle bundleForm = getIntent().getExtras();

        if(bundleForm != null){

            myName.setText(bundleForm.getString("forName"));

            myPhone.setText(bundleForm.getString("forPhone"));

            myEmail.setText(bundleForm.getString("forEmail"));

            myGender.setText(bundleForm.getString("forGender"));

        }

        else{

            Toast.makeText(this, "Sorry, bro", Toast.LENGTH_SHORT).show();

        }
    }
}
