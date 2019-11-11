package com.example.spinnerwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText etName,etEmail,etPhone;

    Spinner spinner;

    Button push;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        final Spinner spinner = findViewById(R.id.gender);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.gender,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        toShow();

        push.setOnClickListener( new View.OnClickListener(){

            @Override

            public void onClick(View v) {



                //Validation

                if(etName.getText().toString().matches("")){

                    etName.setError("Enter Name please");

                    return;

                }

                if(etPhone.getText().toString().matches("")){

                    etPhone.setError("Enter Phone Number please");

                    return;

                }

                if(etEmail.getText().toString().matches("")){

                    etEmail.setError("Enter Name please");

                    return;

                }







                String name, phone, email, gender;

                name = etName.getText().toString();

                phone = etPhone.getText().toString();

                email = etEmail.getText().toString();

                gender = spinner.getSelectedItem().toString();



                Intent intentForm = new Intent(FormActivity.this, DisplayActivity.class);

                intentForm.putExtra("forName", name);

                intentForm.putExtra("forPhone", phone);

                intentForm.putExtra("forEmail",email);

                intentForm.putExtra("forGender",gender);



                startActivity(intentForm);



            }

        });





    }



    @Override

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String text = adapterView.getItemAtPosition(i).toString();

        Toast.makeText(adapterView.getContext(),text,Toast.LENGTH_SHORT).show();

    }



    @Override

    public void onNothingSelected(AdapterView<?> adapterView) {



    }



    private void toShow() {

        etName = findViewById(R.id.myName);

        etPhone = findViewById(R.id.phoneNumber);

        etEmail = findViewById(R.id.Email);

        spinner = findViewById(R.id.gender);

        push= findViewById(R.id.btnSubmit);

    }



    }

