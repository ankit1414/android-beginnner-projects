package com.example.learnspanish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_view);
        ArrayList<Word> nums = new ArrayList<>();
        nums.add(new Word("uno" , "one",R.drawable.one ));
        nums.add(new Word("dos","two",R.drawable.two));
        nums.add(new Word("tres","three",R.drawable.three));
        nums.add(new Word("cuatro","four",R.drawable.four));
        nums.add(new Word("cinco","five",R.drawable.five));
        nums.add(new Word("seis","six",R.drawable.six));
        nums.add(new Word("siete","seven",R.drawable.seven));
        nums.add(new Word("ocho" ,"eight",R.drawable.eight));
        nums.add(new Word("nueve","nine",R.drawable.nine));
        nums.add(new Word("diez","ten",R.drawable.ten));
        nums.add(new Word("once","eleven",R.drawable.eleven));
        nums.add(new Word(" doce","twelve",R.drawable.i12));
        nums.add(new Word("trece","thirteen",R.drawable.i13));
        nums.add(new Word("catorce","fourteen",R.drawable.i14));
        nums.add(new Word("quince","fifteen",R.drawable.i15));
        nums.add(new Word("dieciséis","sixteen",R.drawable.i16));
        nums.add(new Word("diecisiete","seventeen",R.drawable.i17));
        nums.add(new Word("dieciocho","eighteen",R.drawable.i18));
        nums.add(new Word("diecinueve","nineteen",R.drawable.i19));
        nums.add(new Word("veinte","twinty",R.drawable.i20));
        ListView rootview = findViewById(R.id.rootview);

        WordAdapter numberAdapter = new WordAdapter(this, nums ,R.color.category_numbers);
        rootview.setAdapter(numberAdapter);





    }
}
