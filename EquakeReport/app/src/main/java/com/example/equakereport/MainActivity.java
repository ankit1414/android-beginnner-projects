package com.example.equakereport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BackgrountDataFetch thread = new BackgrountDataFetch(this);
        thread.execute();
        //String address = "";
        // Create a fake list of earthquake locations.

    }

    public void setadapterandarraylist(String jsonresponse){
        ArrayList<Edetail> earthquakes = UtilityClass.getearthquakedata(jsonresponse);
//        earthquakes.add(new Edetail(5.5 , "San Francisco" , "02-05-2019"));
//        earthquakes.add(new Edetail(4.8 ,"London" , "07-03-2019"));
//        earthquakes.add(new Edetail(5.5 ,"Tokyo","11-06-2019"));
//        earthquakes.add(new Edetail(5.9 ,"Mexico City","24-03-2019"));
//        earthquakes.add(new Edetail(6.5 ,"Moscow","12-03-2019"));
//        earthquakes.add(new Edetail(5.1 ,"Rio de Janeiro","25-03-2019"));
//        earthquakes.add(new Edetail(7.3 ,"Paris", "17-03-2019"));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        Eadapter adapter = new Eadapter(this , earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }

}
