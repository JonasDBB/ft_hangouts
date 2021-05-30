package com.example.ft_hangouts_v03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ListView contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dbHandler db = new dbHandler(this);

        db.addContact(new Contact("Jonas", "BB", "1234", "j@bb.com", "homelane"));
//        db.addContact(new Contact("dan", "bebe", "4321", "da@bebo.com", "farbvd"));
//        db.addContact(new Contact("me", "yes", "0000", "me@you.com", "nearst"));

//        contactList = findViewById(R.id.listView);
//        ArrayList<Contact> contactdata = db.getAllContacts();
//        contactList.setAdapter(new customArrayAdapter(contactdata, this));
//
//        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Contact contactId = (Contact) parent.getItemAtPosition(position);
//                Intent intent = new Intent(getApplicationContext(), DisplayContact.class);
//
//                Bundle dataBundle = new Bundle();
//                int cId = contactId.getId();
//                dataBundle.putInt("id", cId);
//                intent.putExtras(dataBundle);
//
//                startActivity(intent);
//            }
//        });
    }
}
