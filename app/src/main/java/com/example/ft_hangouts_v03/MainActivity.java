package com.example.ft_hangouts_v03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    dbHandler db = new dbHandler(this);
    ListView contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Log.d("Insert: ","Inserting...");
        db.addContact(new Contact("Jonas", "BB", "1234", "j@bb.com", "home lane"));
        db.addContact(new Contact("dan", "bebe", "4321", "da@bebo.com", "far bvd"));
        db.addContact(new Contact("me", "yes", "0000", "me@you.com", "near st"));

        contactList = (ListView) findViewById(R.id.listView);
        contactList.setAdapter(new ArrayAdapter<Contact>(this,  android.R.layout.simple_list_item_1, db.getAllContacts()));

        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Contact contactId = (Contact) parent.getItemAtPosition(position);
                Integer newId = contactId.getId();
                Intent intent = new Intent(view.getContext(), DisplayContact.class);
                intent.putExtra("id", newId);
                startActivity(intent);
            }

        });



//        Log.d("Reading: ", "Reading all...");
//        List<Contact> contacts = db.getAllContacts();
//        for (Contact cn : contacts)
//        {
//            String log = "Id: " + cn.getId() +
//                    "\nFirst Name: " + cn.getFirstName() +
//                    "\nLast Name: " + cn.getLastName() +
//                    "\nPhone nr: " + cn.getPhoneNr() +
//                    "\nEmail: " + cn.getEmail() +
//                    "\nStreet: " + cn.getStreet();
//            Log.d("Contact: ", log);
//        }
    }
}