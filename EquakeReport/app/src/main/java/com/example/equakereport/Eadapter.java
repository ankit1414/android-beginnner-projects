package com.example.equakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class Eadapter extends ArrayAdapter {
    public Eadapter(Context context, List objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        View listofquakes = convertView;
        if(listofquakes == null){
            listofquakes = LayoutInflater.from(getContext()).inflate(R.layout.list_items , parent , false);
        }
        Edetail earthquakereport = (Edetail)getItem(position);
        TextView mag = listofquakes.findViewById(R.id.mag_id);
        mag.setText("" + earthquakereport.getEqmag());

        TextView location = listofquakes.findViewById(R.id.location_id);
        location.setText(earthquakereport.getEqlocation());

        TextView date = listofquakes.findViewById(R.id.date_id);
        date.setText(earthquakereport.getEqdate());




        return listofquakes;
    }
}
