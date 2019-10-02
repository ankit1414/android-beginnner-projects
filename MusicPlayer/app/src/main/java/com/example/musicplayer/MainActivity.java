package com.example.musicplayer;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //final MediaPlayer mediaPlayer = MediaPlayer.create(this , R.raw.on_my_way);
        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        mediaPlayer = MediaPlayer.create(MainActivity.this , R.raw.on_my_way);
        Button playbutton = findViewById(R.id.Play_button);
        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mediaPlayer = MediaPlayer.create(MainActivity.this , R.raw.on_my_way);
                checkandinitilize();
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this , "playback finished!" , Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        Button pausebutton = findViewById(R.id.pause_button);
        pausebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    //mediaPlayer.prepareAsync();
                }
            }
        });

        Button stopbutton = findViewById(R.id.stop_button);
        stopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.prepareAsync();
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    public void checkandinitilize(){
        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this , R.raw.on_my_way);
        }
    }

}
