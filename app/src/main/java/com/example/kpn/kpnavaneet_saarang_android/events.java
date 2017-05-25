package com.example.kpn.kpnavaneet_saarang_android;

import android.content.Intent;
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


        Intent i = getIntent();
        eventname = i.getStringArrayListExtra("eventname");
        category = i.getStringArrayListExtra("category");
        des = i.getStringArrayListExtra("description");
        sch =i.getStringArrayListExtra("schedule");
        loc=i.getStringArrayListExtra("location");
        contact = i.getStringArrayListExtra("contact");
        ph = i.getStringArrayListExtra("phone");
        CustomListAdapter adapter = new CustomListAdapter(this,R.layout.mylist,eventname);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);


        final ArrayList<String> finalCategory = category;
        final ArrayList<String> finaldes = des;
        final ArrayList<String> finalsch = sch;
        final ArrayList<String> finalloc = loc;
        final ArrayList<String> finalcontact = contact;
        final ArrayList<String> finalph = ph;

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            String categ,des,sch,loc,contact,ph;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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

    public void changepreferance(View view)
    {





    }
}
