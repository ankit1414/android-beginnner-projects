package com.example.justjava;

import android.content.Intent;
import android.net.Uri;
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
    private String name,address,mobileno;
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
                displayPrice(no_of_coffee *(5+tChocolate+tWhippedCream));
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
                displayPrice(no_of_coffee *(5+tChocolate+tWhippedCream));
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
        EditText etmobile = findViewById(R.id.phone_id);
        mobileno = etmobile.getText().toString();
        sendorder(no_of_coffee);
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
        if(no_of_coffee == 0){
            textView.setText("$0");
        } else {
            textView.setText("$" + n);
        }
    }
    private void sendorder(double number){
        //TextView textView= findViewById(R.id.price_text_view);
        String message = "Customer Name : " + name +"\nDelivery address : " + address
                + "\nMobile : " + mobileno
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
        //textView.setText(message);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL , new String[] {"ankitbhardwaj4141@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT , "order from Mr/Ms "+name);
        intent.putExtra(Intent.EXTRA_TEXT , message);
        if(no_of_coffee == 0){
            Toast.makeText(getApplicationContext() , "invalid order" , Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext() , "Please confirm the order by sending  email to us" ,Toast.LENGTH_SHORT).show();

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }

    }


}
