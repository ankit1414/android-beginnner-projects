package com.example.learnspanish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_view);
        ArrayList<Word> nums = new ArrayList<>();

        nums.add(new Word("Amarillo","Yellow" ,R.drawable.color_yellow));

        nums.add(new Word("Rojo","Red",R.drawable.color_red));
        nums.add(new Word("Verde","Green",R.drawable.color_green));
        nums.add(new Word("Negro","Black" ,R.drawable.color_black));

        nums.add(new Word("Gris","Gray" , R.drawable.color_gray));
        nums.add(new Word("Blanco","White" , 0));
        nums.add(new Word("Anaranjado" , "Orange" ,R.drawable.colot_orange));
        nums.add(new Word("Rosado","Pink" ,R.drawable.color_pink));
        nums.add(new Word("Azul","Blue" , R.drawable.color_blue));
        nums.add(new Word("Morado" ,"Purple" , R.drawable.color_purple));
        nums.add(new Word("Bronce","Bronze",R.drawable.defaultimage));
        nums.add(new Word("Plateado","Silver",R.drawable.defaultimage));
        nums.add(new Word(" Dorado","Gold",R.drawable.defaultimage));

        ListView rootview = findViewById(R.id.rootview);

        WordAdapter numberAdapter = new WordAdapter(this, nums , R.color.category_colors);
        rootview.setAdapter(numberAdapter);
    }

}
