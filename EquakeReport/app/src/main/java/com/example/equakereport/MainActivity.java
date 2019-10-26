package com.example.equakereport;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    EditText from ;
    EditText to;
    private ProgressDialog mdialog;
    //Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mtoolbar = findViewById(R.id.custom_toolbar);
        //setSupportActionBar(mtoolbar);
        from = findViewById(R.id.from_et);
        to = findViewById(R.id.to_et);
        final ListofEarthquakesActivity listofEarthquakesActivity = new ListofEarthquakesActivity();
        Button submitbtn = findViewById(R.id.submit_button);
        mdialog = new ProgressDialog(this);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(to.getText().length()== 10 && from.getText().length() == 10) {
                    StringBuilder tosb = new StringBuilder(to.getText().toString());
                    StringBuilder fromsb = new StringBuilder(from.getText().toString());
                    if(tosb.charAt(4) == '-' && tosb.charAt(7) == '-' && fromsb.charAt(4) == '-' && fromsb.charAt(7) == '-') {
                        String [] arr = TextUtils.split(to.getText().toString() , "-");
                        //Toast.makeText(getApplicationContext() , "arr[0] = " +arr[0] , Toast.LENGTH_LONG).show();
                        int yearentered = Integer.parseInt(arr[0]);
                        int monthentered = Integer.parseInt(arr[1]);
                        int dateentered = Integer.parseInt(arr[2]);

                        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

                        String [] arrtoday = TextUtils.split(date , "-");

                        int yearc = Integer.parseInt(arrtoday[0]);
                        int monthc = Integer.parseInt(arrtoday[1]);
                        int datec = Integer.parseInt(arrtoday[2]);

                        String [] arrfrom = TextUtils.split(from.getText().toString() , "-");

                        int yearf = Integer.parseInt(arrfrom[0]);
                        int monthf = Integer.parseInt(arrfrom[1]);
                        int datef = Integer.parseInt(arrfrom[2]);


                        if(yearentered>yearc || (yearentered == yearc && monthentered>monthc) || (yearentered == yearc && monthentered == monthc && dateentered>datec)){
                            Toast.makeText(getApplicationContext() , "To date field is incorrect" , Toast.LENGTH_SHORT).show();
                        } else if(yearf>yearentered || (yearf== yearentered && monthf>monthentered) || (yearf == yearentered && monthf == monthentered && datef>dateentered)){
                            Toast.makeText(getApplicationContext() , "entered fields are invalid please recheck!" , Toast.LENGTH_SHORT).show();
                        }

                        else {
                            BackgrountDataFetch thread = new BackgrountDataFetch(MainActivity.this, listofEarthquakesActivity);
                            mdialog.setMessage("Collecting data...");
                            mdialog.show();
                            thread.execute();

                            //Toast.makeText(getApplicationContext(), "Please wait... Loading data!", Toast.LENGTH_LONG).show();
                        }


                    } else {
                        Toast.makeText(getApplicationContext() , "please enter in valid format" , Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext() , "please enter in valid format" , Toast.LENGTH_LONG).show();
                }
            }
        });

        //String address = "";
        // Create a fake list of earthquake locations.

    }
    public class BackgrountDataFetch extends AsyncTask<URL, Void , String > {
        MainActivity mainActivity ;
        ListofEarthquakesActivity listofEarthquakesActivity;
        StringBuilder websitesb = new StringBuilder("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=");
        //&endtime=2019-07-28&minmagnitude=5";
        //String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        //StringBuilder oneweek = new StringBuilder(date);
        String website = "";

        //Log.v("date is " , ": " +date);



        public BackgrountDataFetch(MainActivity a , ListofEarthquakesActivity listofEarthquakesActivity){
            mainActivity = a;
            this.listofEarthquakesActivity = listofEarthquakesActivity;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            websitesb.append(mainActivity.from.getText().toString()+"&endtime="+mainActivity.to.getText().toString() + "&minmagnitude=5");
            website = websitesb.toString();
        }

        @Override
        protected void onPostExecute(String s) {

            super.onPostExecute(s);
            Intent intent  = new Intent(MainActivity.this , ListofEarthquakesActivity.class);
            intent.putExtra("message",s);
            mdialog.dismiss();
            startActivity(intent);
            //listofEarthquakesActivity.setadapterandarraylist(s);
            //Log.v("date is " , ": " +date);


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
                urlConnection.setReadTimeout(100000);
                urlConnection.setConnectTimeout(150000);
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



}
