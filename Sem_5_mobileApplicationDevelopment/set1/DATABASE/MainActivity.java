package com.example.myapplication7android;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);


        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Angel", "9100000000"));
        db.addContact(new Contact("Amin", "9199999999"));
        db.addContact(new Contact("Rudra", "9522222222"));
        db.addContact(new Contact("Akshay", "9533333333"));


        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getPhoneNumber();

            Log.d("Name: ", log);
        }}}


