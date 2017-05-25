package com.example.kpn.kpnavaneet_saarang_android;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class details extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //Intent from class mainActivity that displays the details of the event.

        final Intent i = getIntent();
        Bundle b = i.getExtras();
        if (b != null) {
            final String s = i.getStringExtra("category");
            String des = i.getStringExtra("description");
            String sch = i.getStringExtra("schedule");
            String loc = i.getStringExtra("location");
            String c = i.getStringExtra("contact");
            final String ph = i.getStringExtra("phone");
            TextView categorytext = (TextView) findViewById(R.id.categorytext);
            categorytext.setText(s);
            TextView descriptiontext = (TextView) findViewById(R.id.descriptiontext);
            descriptiontext.setText(des);
            TextView scheduletext = (TextView) findViewById(R.id.scheduletext);
            scheduletext.setText(sch);
            TextView locationtext = (TextView) findViewById(R.id.locationtext);
            locationtext.setText(loc);
            TextView cordtext = (TextView) findViewById(R.id.cordtext);
            cordtext.setText(c);

            //onClickListener method for the call the coordinator functionality

            ImageButton callbutton = (ImageButton) findViewById(R.id.callbutton);
            callbutton.setOnClickListener(new ImageButton.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callintent = new Intent(Intent.ACTION_CALL);
                    callintent.setData(Uri.parse("tel:" + ph));
                    if (ActivityCompat.checkSelfPermission(details.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(callintent);


                }
            });

            //onClickListener method to allow user to send mails to the coordinator .

            ImageButton mailbutton= (ImageButton) findViewById(R.id.mailbutton);
            mailbutton.setOnClickListener(new ImageButton.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] TO = {""};
                    String[] CC = {""};
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);

                    emailIntent.setData(Uri.parse("mailto:"));
                    emailIntent.setType("text/plain");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                    emailIntent.putExtra(Intent.EXTRA_CC, CC);
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

                    try {
                        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                        finish();

                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(details.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            //onClickListener method to allow user to add the event to the calendar .

            ImageButton calendar = (ImageButton) findViewById(R.id.calendar);
            calendar.setOnClickListener(new ImageButton.OnClickListener() {


                @Override
                public void onClick(View v) {

                    Calendar cal = null;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        cal = Calendar.getInstance();
                    }
                    Intent intent = new Intent(Intent.ACTION_EDIT);
                        intent.setType("vnd.android.cursor.item/event");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        intent.putExtra("beginTime", cal.getTimeInMillis());
                    }
                    intent.putExtra("allDay", true);
                        intent.putExtra("rrule", "FREQ=YEARLY");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        intent.putExtra("endTime", cal.getTimeInMillis()+60*60*1000);
                    }
                    intent.putExtra("title", s);
                        startActivity(intent);


                }
            });


        }

    }

    //onClick method for the Register button
    //on clicking button goes to another activity .

    public void register(View view)
    {
        Intent i = new Intent(this,register.class);
        startActivity(i);
    }

}
