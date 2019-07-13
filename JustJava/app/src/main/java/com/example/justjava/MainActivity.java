package com.example.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static int no_of_coffee = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = findViewById(R.id.decrease_button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(no_of_coffee>=1){
                    no_of_coffee--;
                    display(no_of_coffee);
                    displayPrice(no_of_coffee * 5);
                }
            }
        });
        Button b2 = findViewById(R.id.increase_button);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++no_of_coffee;
                display(no_of_coffee);
                displayPrice(no_of_coffee *5);
            }
        });
    }
    public void submitOrder(View view){

        //display(no_of_coffee);
        //displayPrice(no_of_coffee*5);
        Toast.makeText(getApplicationContext() , "order confirmed!" ,Toast.LENGTH_SHORT).show();
        no_of_coffee = 0;
        display(no_of_coffee);
        displayPrice(no_of_coffee);

    }
    private void display(int n){
        TextView textView = findViewById(R.id.text2);
        textView.setText("" + n);
    }
    private void displayPrice(int number){
        TextView textView= findViewById(R.id.price_text_view);
        textView.setText(NumberFormat.getCurrencyInstance().format(number));
    }


}
