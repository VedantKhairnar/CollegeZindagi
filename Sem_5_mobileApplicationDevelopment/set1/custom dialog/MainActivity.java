package com.example.customdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                View view1=getLayoutInflater().inflate(R.layout.login,null);
              //  EditText e1= (EditText) view1.findViewById(R.id.e1);
                //EditText e2= (EditText) view1.findViewById(R.id.e2);
                Button b1 = (Button) view1.findViewById(R.id.b1);
                Button b2 = (Button) view1.findViewById(R.id.b2);
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,"sign in success",Toast.LENGTH_LONG).show();
                    }
                });
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,"canceled",Toast.LENGTH_LONG).show();
                    }
                });
builder.setView(view1);
AlertDialog alert = builder.create();
alert.show();
            }
        });
    }
}
