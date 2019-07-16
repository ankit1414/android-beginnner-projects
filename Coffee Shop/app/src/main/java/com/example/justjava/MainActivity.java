package com.example.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static double tWhippedCream= 0, tChocolate = 0;
    private int no_of_coffee = 0;
    private String name,address;
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
                    displayPrice(no_of_coffee *(5+tChocolate+tWhippedCream));
                }
            }
        });
        Button b2 = findViewById(R.id.increase_button);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++no_of_coffee;
                display(no_of_coffee);
                displayPrice(no_of_coffee *(5+tChocolate+tWhippedCream));

            }
        });
        final CheckBox whippedCream = findViewById(R.id.whipped_creame_checkbox);
        whippedCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(whippedCream.isChecked())
                    tWhippedCream = 1;
                else
                    tWhippedCream = 0;
            }
        });
        final CheckBox chocolate = findViewById(R.id.chocolate_checkbox);
        chocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chocolate.isChecked()){
                    tChocolate = 0.5;
                }
                else {
                    tChocolate =0;
                }
            }
        });

//        EditText et = findViewById(R.id.name_id);
//        name = et.getText().toString();
    }
    public void submitOrder(View view){

        //display(no_of_coffee);
        //displayPrice(no_of_coffee*5);
        EditText et = findViewById(R.id.name_id);
        name = et.getText().toString();
        EditText etAddress  = findViewById(R.id.address_id);
        address = etAddress.getText().toString();
        displaySummary(no_of_coffee);
        Toast.makeText(getApplicationContext() , "order confirmed!" ,Toast.LENGTH_SHORT).show();
        //no_of_coffee = 0;
        //display(no_of_coffee);
        //displayPrice(no_of_coffee);

    }
    private void display(int n){
        TextView textView = findViewById(R.id.text2);
        textView.setText("" + n);
    }

    private void displayPrice(double n){
        TextView textView = findViewById(R.id.price_text_view);
        textView.setText("$" + n);
    }
    private void displaySummary(double number){
        TextView textView= findViewById(R.id.price_text_view);
        String message = "Customer Name : " + name +"\nDelivery address : " + address
                        +"\nQuantity : " + no_of_coffee +"\nToppings :" ;
        CheckBox WhippedCream = findViewById(R.id.whipped_creame_checkbox);
        if(WhippedCream.isChecked()){
            message = message + " \" Whipped Cream\"";
        }
        CheckBox Chocolate = findViewById(R.id.chocolate_checkbox);
        if(Chocolate.isChecked()){
            message = message + " \" Chocolate\"";
        }
        message = message + "\nPayable amount : $" + number*(5+tChocolate+tWhippedCream);
        textView.setText(message);
    }


}
