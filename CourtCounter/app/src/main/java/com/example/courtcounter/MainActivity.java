package com.example.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int aScore = 0;
    private int bScore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button a3plusButton ;
        a3plusButton= findViewById(R.id.a3plus);
        a3plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aScore +=3;
                adisplayScore(aScore);
            }
        });
        Button a2plusButton;
        a2plusButton= findViewById(R.id.a2plus);
        a2plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aScore +=2;
                adisplayScore(aScore);
            }
        });
        Button aFreeThrow ;
        aFreeThrow= findViewById(R.id.aFreeThrow);
        aFreeThrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aScore +=1;
                adisplayScore(aScore);
            }
        });

        Button b3plusButton ;
        b3plusButton= findViewById(R.id.b3plus);
        b3plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bScore +=3;
                bdisplayScore(bScore);
            }
        });
        Button b2plusButton ;
        b2plusButton= findViewById(R.id.b2plus);
        b2plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bScore +=2;
                bdisplayScore(bScore);
            }
        });
        Button bFreeThrow;
        bFreeThrow= findViewById(R.id.bFreeThrow);
        bFreeThrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bScore +=1;
                bdisplayScore(bScore);
            }
        });

        Button resetButton ;
        resetButton= findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aScore = 0;
                bScore = 0;
                adisplayScore(aScore);
                bdisplayScore(bScore);
            }
        });
    }

    public void adisplayScore(int score){
        TextView aScoretv = findViewById(R.id.aScoreTextView);
//        TextView bScoretv = findViewById(R.id.bScoreTextView);
        aScoretv.setText(""+score);
    }
    public void bdisplayScore(int score){
//        TextView aScoretv = findViewById(R.id.aScoreTextView);
        TextView bScoretv = findViewById(R.id.bScoreTextView);
        bScoretv.setText(""+score);
    }

}
