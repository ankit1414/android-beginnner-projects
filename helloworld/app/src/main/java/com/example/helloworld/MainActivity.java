package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView tv;
    Button logout_button;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= findViewById(R.id.clickme);
        tv= findViewById(R.id.text1);
        img= findViewById(R.id.img);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Welcome Ankit");
                img.setImageResource(R.drawable.aaaa);
                tv.setTextColor(getResources().getColor(R.color.colorAccent));
                Toast.makeText(getApplicationContext(),"you are logged in as ankit",Toast.LENGTH_SHORT).show();
            }
        });
        logout_button = findViewById(R.id.logoutbutton);
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Please login");
                tv.setTextColor(getResources().getColor(R.color.colorAccent));
                img.setImageResource(R.drawable.initial_background);
                Toast.makeText(getApplicationContext(),"logged out successfully",Toast.LENGTH_SHORT).show();
            }
        });



    }
}
