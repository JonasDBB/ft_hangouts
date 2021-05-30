package com.example.ft_hangouts_v03;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayContact extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    EditText phoneNr;
    EditText email;
    EditText street;
    int id;

    dbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_contact);


    }
}
