package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { Button b1;
CharSequence []charr={"Apple","Android","Mototrola"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("this the title");
                builder.setIcon(R.mipmap.ic_launcher);
builder.setPositiveButton("okay", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        Toast.makeText(MainActivity.this,"okay clicked",Toast.LENGTH_LONG).show();

    }

});

builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        Toast.makeText(MainActivity.this,"cancel clicked",Toast.LENGTH_LONG).show();


    }
});
builder.setMultiChoiceItems(charr, new boolean[charr.length], new DialogInterface.OnMultiChoiceClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
        Toast.makeText(MainActivity.this,charr[i]+(b?"checked":"unchecked"),Toast.LENGTH_LONG).show();
    }
});

               AlertDialog alertDialog= builder.create();
               alertDialog.setCancelable(true);
               alertDialog.show();


            }
        });
    }
}
