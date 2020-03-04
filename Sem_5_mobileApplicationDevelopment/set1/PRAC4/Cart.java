package com.example.prac4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.prac4.MainActivity.price;
import static com.example.prac4.MainActivity.result;

public class Cart extends AppCompatActivity {

    TextView tv;
    Button bb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        tv=findViewById(R.id.tv);
        tv.setText(result);
        bb=findViewById(R.id.bb);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(getApplicationContext(),"Total="+price,Toast.LENGTH_LONG).show();

                AlertDialog.Builder ad=new AlertDialog.Builder(Cart.this);
                ad.setMessage("Rs."+price);
                ad.setTitle("!!!!!Total Amount to be Paid!!!!!");
                ad.setCancelable(true);

                AlertDialog aa=ad.create();
                aa.show();
            }
        });

    }
}

