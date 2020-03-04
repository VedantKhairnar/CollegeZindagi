package com.example.notificationfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
            }
        });
    }


   private void send( ){

                NotificationCompat.Builder builder;
       builder =new NotificationCompat.Builder(this)
       .setSmallIcon(R.mipmap.ic_launcher)
              //adding actions(optional


                .setContentTitle("6 new messages")
                .setContentText("@android.com")
                .setSubText("tap to view website");
       Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"));
       PendingIntent pendingIntent =  PendingIntent.getActivity(MainActivity.this,0,i,0);
       //second is adding properties



       builder.setContentIntent(pendingIntent);
                //fourth step is issue notification
                NotificationManager noti=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                noti.notify(0,builder.build());}
            }



