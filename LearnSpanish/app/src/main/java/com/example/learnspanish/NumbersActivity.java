package com.example.learnspanish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ArrayList<String> nums = new ArrayList<>();
        nums.add(new Word("uno" , "one" ).toString());
        nums.add(new Word("dos","two").toString());
        nums.add(new Word("tres","three").toString());
        nums.add(new Word("cuatro","four").toString());
        nums.add(new Word("cinco","five").toString());
        nums.add(new Word("seis","six").toString());
        nums.add(new Word("siete","seven").toString());
        nums.add(new Word("ocho" ,"eight").toString());
        nums.add(new Word("nueve","nine").toString());
        nums.add(new Word("diez","ten").toString());
        nums.add(new Word("once","eleven").toString());
        nums.add(new Word(" doce","twelve").toString());
        nums.add(new Word("trece","thirteen").toString());
        nums.add(new Word("catorce","fourteen").toString());
        nums.add(new Word("quince","fifteen").toString());
        nums.add(new Word("dieciséis","sixteen").toString());
        nums.add(new Word("diecisiete","seventeen").toString());
        nums.add(new Word("dieciocho","eighteen").toString());

        ListView rootview = findViewById(R.id.rootview);

//        for(int i=0; i<nums.size(); i++){
//            TextView temp = new TextView(this);
//            temp.setText(nums.get(i));
//            rootview.addView(temp);
//        }
        ArrayAdapter<String> numberAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1 , nums);
        rootview.setAdapter(numberAdapter);





    }
}
