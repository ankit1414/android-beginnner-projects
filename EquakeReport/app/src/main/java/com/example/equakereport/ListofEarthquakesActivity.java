package com.example.equakereport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListofEarthquakesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquakelist);
        Bundle bundle  = getIntent().getExtras();
        String jsonresponse = bundle.getString("message");
        setadapterandarraylist(jsonresponse);

    }
    public void setadapterandarraylist(String jsonresponse){
        ArrayList<Edetail> earthquakes = UtilityClass.getearthquakedata(jsonresponse);

        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        Eadapter adapter = new Eadapter(this , earthquakes);

        earthquakeListView.setAdapter(adapter);
    }
}
