package com.example.equakereport;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public final class UtilityClass {



    private UtilityClass(){

    }

    public static ArrayList<Edetail> getearthquakedata(String data){

        ArrayList<Edetail> listOfEarthquakes = new ArrayList<>();

        try{

            JSONObject rootjson = new JSONObject(data);

            JSONArray featurearray = rootjson.getJSONArray("features");

            for(int i=0 ; i<featurearray.length(); i++){

                JSONObject currentobject = featurearray.getJSONObject(i);

                JSONObject properties = currentobject.getJSONObject("properties");

                Double mag  = properties.getDouble("mag");

                String location  = properties.getString("place");

                String time  = properties.getString("time");

                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String date = formatter.format(Long.parseLong(time));

                Edetail temp = new Edetail(mag , location , date);

                listOfEarthquakes.add(temp);


            }



        } catch (JSONException e){

            Log.v("json exception" , "exception encountered");

        }




        return listOfEarthquakes;
    }
}
