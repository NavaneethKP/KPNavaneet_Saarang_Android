package com.example.kpn.kpnavaneet_saarang_android;

import android.content.Context;
        import android.support.annotation.LayoutRes;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import java.util.ArrayList;

/**
 * Created by kpn on 24/5/17.
 */

public class CustomListAdapter extends ArrayAdapter<String> {

    ArrayList<String> string = new ArrayList<String>();
    private final Context context;


    public CustomListAdapter(@NonNull Context context, @LayoutRes int resource,ArrayList string) {
        super(context, resource,string);
        this.context=context;
        this.string=string;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View rowview = inflater.inflate(R.layout.mylist,parent,false);
        TextView text= (TextView) rowview.findViewById(R.id.text);
        text.setText(string.get(position));
        return rowview;




    }
}

