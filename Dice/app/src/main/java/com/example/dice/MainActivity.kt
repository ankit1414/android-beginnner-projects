package com.example.dice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch

import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var diceimage: ImageView
    lateinit var rollButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceimage = findViewById(R.id.dice_image)
        rollButton = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            val rnum = Random().nextInt(6) + 1
            //Log.v("rnum is =" , rnum.toString())
            when(rnum){
                1-> diceimage.setImageResource(R.drawable.dice_1)
                2-> diceimage.setImageResource(R.drawable.dice_2)
                3-> diceimage.setImageResource(R.drawable.dice_3)
                4-> diceimage.setImageResource(R.drawable.dice_4)
                5-> diceimage.setImageResource(R.drawable.dice_5)
                6-> diceimage.setImageResource(R.drawable.dice_6)
            }
        }
    }
}
