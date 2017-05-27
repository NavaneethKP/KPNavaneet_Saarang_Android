package com.example.kpn.kpnavaneet_saarang_android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//Declaring the array list for storing the data according to user's choice .

    ArrayList<String> string = new ArrayList<String>();
    ArrayList<String> category = new ArrayList<String>();
    ArrayList<String> des = new ArrayList<String>();
    ArrayList<String> sch = new ArrayList<String>();
    ArrayList<String> loc = new ArrayList<String>();
    ArrayList<String> cord = new ArrayList<String>();
    ArrayList<String> ph = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = this.getSharedPreferences("PREFS",0);
        if(settings.getString("saved","")!="")
        {
            Intent i = new Intent(this,events.class);
            startActivity(i);
            Log.i("com.example.kpn.kpnavaneet_saarang_android","called");
            finish();

        }
    }

//onClick method to display the events for respective categories chosen by the user.

    public void buttonclick(View view)
    {


        if(string.isEmpty())
            string.add("Nothing to show");

        saveprefs();
        Intent i = new Intent(this,events.class);
        startActivity(i);
        finish();

    }

    //The onClick method for the checboxes .

    public void category(View view)
    {
        //To clear "Nothing to show" if the user selects an option .

        if(string.size()==1){
            string.clear();

        }

        boolean checked = ((CheckBox) view).isChecked();

        //switch case statements to assign data to the ArrayList<> as checked by the user .

        switch(view.getId())
        {
            case R.id.c1:if(checked)
            {
                string.add("Buzzer Quiz");string.add("India Quiz");
                category.add("Quiz"); category.add("Quiz");
                des.add(getString(R.string.Buzzer)); des.add(getString(R.string.India));
                sch.add("2017-01-05  10:00 AM"); sch.add("2017-01-08  10:00 AM");
                loc.add("CRC 101"); loc.add("CRC 101");
                cord.add(getString(R.string.c1)); cord.add(getString(R.string.c2));
                ph.add("9790469683");   ph.add("9790469683");


            }
            else
            {
                string.remove("Buzzer Quiz"); string.remove("India Quiz");
                category.remove("Quiz"); category.remove("Quiz");
                des.remove(getString(R.string.Buzzer)); des.remove(getString(R.string.India));
                sch.remove("2017-01-05 , 10:00 AM"); sch.remove("2017-01-08 , 10:00 AM");
                loc.remove("CRC 101"); loc.remove("CRC 101");
                cord.remove(getString(R.string.c1)); cord.remove(getString(R.string.c2));
                ph.remove("9790469683");   ph.remove("9790469683");

            }
                break;

            case R.id.c2:if (checked)
            {
                string.add("Cornucopia");string.add("Rangrez");
                category.add("FineArts"); category.add("FineArts");
                des.add(getString(R.string.Cornucopia)); des.add(getString(R.string.Rangrez));
                sch.add("2017-01-05  9:30 AM");sch.add("2017-01-08  10:00 AM");
                loc.add("Fine Arts Hut"); loc.add("Fine Arts Hut");
                cord.add(getString(R.string.c3)); cord.add(getString(R.string.c4));
                ph.add("9176492387"); ph.add("9003033685");


            }
            else
            {
                string.remove("Cornucopia");string.remove("Rangrez");
                category.remove("FineArts"); category.remove("FineArts");
                des.remove(getString(R.string.Cornucopia)); des.remove(getString(R.string.Rangrez));
                sch.remove("2017-01-05  9:30 AM");sch.remove("2017-01-08  10:00 AM");
                loc.remove("Fine Arts Hut"); loc.remove("Fine Arts Hut");
                cord.remove(getString(R.string.c3)); cord.remove(getString(R.string.c4));
                ph.remove("9176492387"); ph.remove("9003033685");


            }
                break;

            case R.id.c3:if(checked)
            {
                string.add("FIFA tournament");string.add("DOTA 2 tournament");
                category.add("Gaming"); category.add("Gaming");
                des.add(getString(R.string.Fifa)); des.add(getString(R.string.Dota));
                sch.add("2017-01-08  10:30 AM");sch.add("2017-01-07  10:30 AM");
                loc.add("KV Grounds"); loc.add("KV Grounds");
                cord.add(getString(R.string.c5)); cord.add(getString(R.string.c6));
                ph.add("9789855067");   ph.add("9500158866");


            }
            else
            {
                string.remove("FIFA tournament");string.remove("DOTA 2 tournament");
                category.remove("Gaming"); category.remove("Gaming");
                des.remove(getString(R.string.Fifa)); des.remove(getString(R.string.Dota));
                sch.remove("2017-01-08  10:30 AM");sch.remove("2017-01-07  10:30 AM");
                loc.remove("KV Grounds"); loc.remove("KV Grounds");
                cord.remove(getString(R.string.c5)); cord.remove(getString(R.string.c6));
                ph.remove("9789855067");   ph.remove("9500158866");


            }
                break;


        }
    }

    public void saveprefs()
    {
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        StringBuilder stringBuilder4 = new StringBuilder();
        StringBuilder stringBuilder5 = new StringBuilder();
        StringBuilder stringBuilder6 = new StringBuilder();
        StringBuilder stringBuilder7 = new StringBuilder();
        for(String s1 : string){
            stringBuilder1.append(s1);
            stringBuilder1.append(",");
        }
        for(String s2 : category)
        {
            stringBuilder2.append(s2);
            stringBuilder2.append(",");
        }
        for(String s3 : des)
        {
            stringBuilder3.append(s3);
            stringBuilder3.append(",");
        }
        for(String s4 : sch)
        {
            stringBuilder4.append(s4);
            stringBuilder4.append(",");
        }
        for(String s5 : loc)
        {
            stringBuilder5.append(s5);
            stringBuilder5.append(",");
        }
        for(String s6 : cord)
        {
            stringBuilder6.append(s6);
            stringBuilder6.append(",");
        }
        for(String s7 : ph)
        {
            stringBuilder7.append(s7);
            stringBuilder7.append(",");
        }
        SharedPreferences settings = this.getSharedPreferences("PREFS",0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("saved","saved");
        editor.putString("events",stringBuilder1.toString());
        editor.putString("category",stringBuilder2.toString());
        editor.putString("description",stringBuilder3.toString());
        editor.putString("schedule",stringBuilder4.toString());
        editor.putString("location",stringBuilder5.toString());
        editor.putString("contact",stringBuilder6.toString());
        editor.putString("phone",stringBuilder7.toString());
        editor.commit();

    }

}

