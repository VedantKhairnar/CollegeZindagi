package com.example.prac4;

import android.content.Intent;
import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prac4.R;

public class MainActivity extends AppCompatActivity {

    public static int price=0;
    public static String result="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id==R.id.ref)
        {
            result="";
            price=0;
        }
        if(id==R.id.as)
        {
            Intent i=new Intent(getApplicationContext(),Aboutus.class);
            startActivity(i);
            return true;
        }

        if(id==R.id.cart)
        {
            //Toast.makeText(this,"Price="+price,Toast.LENGTH_LONG).show();
            Intent i=new Intent(this,Cart.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.cl) {
            return true;
        }


        if(id==R.id.sh){
            Intent i=new Intent(getApplicationContext(),Shoes.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.eg) {
            return true;
        }
        if (id == R.id.mob) {
            return true;
        }
        if(id== R.id.cl1){
            Intent i=new Intent(getApplicationContext(),Clothes.class);
            startActivity(i);
            return true;
        }

        if(id==R.id.cl2){
            Intent i=new Intent(getApplicationContext(),Womens.class);
            startActivity(i);
            return true;
        }

        if(id==R.id.cl3){
            Intent i=new Intent(getApplicationContext(),Shoes.class);
            startActivity(i);
            return true;
        }



        return super.onOptionsItemSelected(item);
    }
}
