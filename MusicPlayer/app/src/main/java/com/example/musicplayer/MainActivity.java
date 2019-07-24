package com.example.musicplayer;

import android.media.MediaPlayer;
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
        mediaPlayer = MediaPlayer.create(MainActivity.this , R.raw.on_my_way);
        Button playbutton = findViewById(R.id.Play_button);
        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                mediaPlayer.pause();
                //mediaPlayer.prepareAsync();

            }
        });

        Button stopbutton = findViewById(R.id.stop_button);
        stopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.prepareAsync();
            }
        });
    }
}
