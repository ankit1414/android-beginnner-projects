package com.example.learnspanish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // #1
        TextView numbers = findViewById(R.id.numbers);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersactiviy = new Intent(MainActivity.this , NumbersActivity.class);
                startActivity(numbersactiviy);
            }
        });
        // #2
        TextView family = findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent familyactiviy = new Intent(MainActivity.this , FamilyActivity.class);
                startActivity(familyactiviy);
            }
        });

        // #3
        TextView colors = findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorsactivity = new Intent(MainActivity.this , ColorsActivity.class);
                startActivity(colorsactivity);
            }
        });


        // #4
        TextView phrases = findViewById(R.id.phrases);
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phrasesactiviy = new Intent(MainActivity.this , PhrasesActivity.class);
                startActivity(phrasesactiviy);
            }
        });
    }
}
