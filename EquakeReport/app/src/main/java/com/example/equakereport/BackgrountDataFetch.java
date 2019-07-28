package com.example.equakereport;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.nio.charset.Charset;

import javax.net.ssl.HttpsURLConnection;

public class BackgrountDataFetch extends AsyncTask<URL, Void , String > {
    MainActivity mainActivity ;
    String website = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2019-06-01&endtime=2019-07-28&minmagnitude=5";

    public BackgrountDataFetch(MainActivity a){
        mainActivity = a;
    }
    @Override
    protected void onPostExecute(String s) {

        super.onPostExecute(s);
        mainActivity.setadapterandarraylist(s);


    }

    @Override
    protected String doInBackground(URL... urls) {
        String jsonresponse = "";
        URL url = null ;

        try {
            url = new URL(website);
        } catch (MalformedURLException e){
            Log.e("url exception" , "cant generate url");
        }

        HttpsURLConnection urlConnection = null;
        InputStream inputStream = null;
        try{

            urlConnection  =(HttpsURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.connect();

            inputStream = urlConnection.getInputStream();
            jsonresponse = readfromstream(inputStream);
        } catch (IOException e){
            Log.e("connection error" , "error opening connection");


        } finally {
            if(urlConnection != null){
                urlConnection.disconnect();
            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e){

                }
            }
        }

        Log.v("val is :" ," " +jsonresponse);

        return jsonresponse;
    }

    private  String readfromstream(InputStream inputStream){

        StringBuilder output = new StringBuilder();
        if(inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            try {
                String line = reader.readLine();
                while (line != null) {
                    output.append(line);
                    line = reader.readLine();
                }
            } catch (IOException e){
                Log.e("readline error" , "readline error");
            }

        }
        return output.toString();

    }
}
