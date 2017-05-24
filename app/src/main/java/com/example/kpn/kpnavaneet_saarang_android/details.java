package com.example.kpn.kpnavaneet_saarang_android;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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

        Intent i = getIntent();
        Bundle b = i.getExtras();
        if (b != null) {
            String s = i.getStringExtra("category");
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

        }

    }

    public void register(View view)
    {
        Intent i = new Intent(this,register.class);
        startActivity(i);
    }





}
