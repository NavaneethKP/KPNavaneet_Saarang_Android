package com.example.kpn.kpnavaneet_saarang_android;

import android.content.Context;
import android.support.annotation.ArrayRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class CustomListAdapter extends ArrayAdapter<String> {

    ArrayList<String> string = new ArrayList<String>();
    private final Context context;


//Constructor for the class .

    public CustomListAdapter(@NonNull Context context, @LayoutRes int resource,ArrayList string) {
        super(context, resource,string);
        this.context=context;
        this.string=string;

    }

//Override method to inflate each of the rows with the list item and also set an image .

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View rowview = inflater.inflate(R.layout.mylist,parent,false);
        TextView text= (TextView) rowview.findViewById(R.id.text);
        text.setText(string.get(position));
        ImageView image = (ImageView) rowview.findViewById(R.id.image);
        if(string.size()!=1)
        {
            switch(string.get(position))
            {
                case "Buzzer Quiz":image.setImageResource(R.drawable.buz);
                                    break;
               case "India Quiz":image.setImageResource(R.drawable.india);
                    break;
                case "Cornucopia":image.setImageResource(R.drawable.corn);
                    break;
                case "Rangrez":image.setImageResource(R.drawable.rang);
                    break;
                case "FIFA tournament":image.setImageResource(R.drawable.fifa);
                    break;
                case "DOTA 2 tournament":image.setImageResource(R.drawable.dota);
                    break;


            }
        }
        return rowview;
    }
}

