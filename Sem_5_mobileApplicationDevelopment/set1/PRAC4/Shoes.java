package com.example.prac4;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import static com.example.prac4.MainActivity.price;
import static com.example.prac4.MainActivity.result;


public class Shoes extends AppCompatActivity {

    Button b1,b2,b3;
    Spinner sp1,sp2,sp3;
    String str[]={"1","2","3","4","5"};
    int n,m,z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes);
        b1=findViewById(R.id.clb1);
        b2=findViewById(R.id.clb2);
        b3=findViewById(R.id.clb3);

        sp1=findViewById(R.id.sp1);
        sp2=findViewById(R.id.sp2);
        sp3=findViewById(R.id.sp3);
        ArrayAdapter<String> ad=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,str);
        sp1.setAdapter(ad);
        sp2.setAdapter(ad);
        sp3.setAdapter(ad);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                n=Integer.parseInt(str[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                m=Integer.parseInt(str[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                z=Integer.parseInt(str[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price=price+(n*274);
                result=result+"\n----------------------------------\nAllez Kross Men's"+"\nQuantity:-"+n+"\nRs."+(n*274);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price=price+(m*875);
                result=result+"\n------------------------------------\nSparx Men's"+"\nQuantity:-"+m+"\nRs."+(m*875);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price=price+(z*499);
                result=result+"\n-----------------------------------\nARISE Shoes"+"\nQuantity:-"+z+"\nRs."+(z*499);
            }
        });
    }
}

