package com.example.kpn.kpnavaneet_saarang_android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ArrayList<String> eventname= new ArrayList<String>();
        ArrayList<String> category= new ArrayList<String>();
        ArrayList<String> des= new ArrayList<String>();
        ArrayList<String> sch= new ArrayList<String>();
        ArrayList<String> loc= new ArrayList<String>();
        ArrayList<String> contact= new ArrayList<String>();
        ArrayList<String> ph= new ArrayList<String>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

       //Getting the values for details from sharedPreferences

        Intent i = getIntent();

        //Calling function getpref () to getpreferences

        eventname=getpref("events",eventname);
        category=getpref("category",category);
        des= getpref("description",des);
        sch=getpref("schedule",sch);
        loc=getpref("location",loc);
        contact=getpref("contact",contact);
        ph=getpref("phone",ph);

        //Adapter used to convert the eventname and image into a list item .

        CustomListAdapter adapter = new CustomListAdapter(this,R.layout.mylist,eventname);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        //final variables created in order to be used in OnItemClickListener method

        final ArrayList<String> finalCategory = category;
        final ArrayList<String> finaldes = des;
        final ArrayList<String> finalsch = sch;
        final ArrayList<String> finalloc = loc;
        final ArrayList<String> finalcontact = contact;
        final ArrayList<String> finalph = ph;

        //OnItemClickListener method which leads to the details activity .

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Wrapping all the event details as a Bundle and sending to the
                //details activity

                Intent i = new Intent(events.this,details.class);
                Bundle extras = new Bundle();
                extras.putString("category",finalCategory.get(position));
                extras.putString("description",finaldes.get(position));
                extras.putString("schedule",finalsch.get(position));
                extras.putString("location",finalloc.get(position));
                extras.putString("contact",finalcontact.get(position));
                extras.putString("phone",finalph.get(position));
                i.putExtras(extras);
                startActivity(i);
            }
        });


    }

    //onCLick method for the button to go to the MainActivity
    //and allows to change the categories preferred.

    public void change(View view)
    {
        Intent i = new Intent(events.this,MainActivity.class);
        i.putExtra("flag",1);
        startActivity(i);
        finish();
    }

    //New method created to get preferences using SharedPreferences

    public ArrayList<String> getpref(String key,ArrayList<String> list)
    {
        SharedPreferences settings = events.this.getSharedPreferences("PREFS",0);
        String string = settings.getString(key,"");
        String[] strings=string.split(",");
        for(String newstring : strings)
        {
            list.add(newstring);
        }
        return list;
    }

}
