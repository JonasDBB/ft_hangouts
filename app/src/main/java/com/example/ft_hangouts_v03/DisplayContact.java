package com.example.ft_hangouts_v03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayContact extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    EditText phoneNr;
    EditText email;
    EditText street;
    int id;
    Button save;
    Button delete;

    dbHandler db;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_contact);

        db = new dbHandler(this);
        Bundle extras = getIntent().getExtras();
        id = extras.getInt("id");
        contact = db.getContact(id);

        firstName = findViewById(R.id.textFirstName);
        lastName = findViewById(R.id.textLastName);
        phoneNr = findViewById(R.id.textPhoneNr);
        email = findViewById(R.id.textEmail);
        street = findViewById(R.id.textStreet);
        save = findViewById(R.id.saveButton);
        delete = findViewById(R.id.deleteButton);

        firstName.setText(contact.getFirstName(), TextView.BufferType.EDITABLE);
        lastName.setText(contact.getLastName(), TextView.BufferType.EDITABLE);
        phoneNr.setText(contact.getPhoneNr(), TextView.BufferType.EDITABLE);
        email.setText(contact.getEmail(), TextView.BufferType.EDITABLE);
        street.setText(contact.getStreet(), TextView.BufferType.EDITABLE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact contact = new Contact(firstName.getText().toString(), lastName.getText().toString(), phoneNr.getText().toString(), email.getText().toString(), street.getText().toString());
                if (db.updateContact(contact, id))
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Updating failed", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteContact(id);
                Toast.makeText(getApplicationContext(), "Contact deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
