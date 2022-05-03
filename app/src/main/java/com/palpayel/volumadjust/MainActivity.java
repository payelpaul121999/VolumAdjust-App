package com.palpayel.volumadjust;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button up_btn,dwn_btn;
 private AudioManager audioManager;
SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar=findViewById(R.id.seekBar);
        dwn_btn=findViewById(R.id.dwn_btn);
        up_btn=findViewById(R.id.up_btn);

        audioManager=(AudioManager)getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
        seekBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));




        up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audioManager.adjustVolume(AudioManager.ADJUST_RAISE,AudioManager.FLAG_PLAY_SOUND);
                seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
                Toast.makeText(MainActivity.this, "Up Volume", Toast.LENGTH_SHORT).show();
            }
        });
        dwn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                audioManager.adjustVolume(AudioManager.ADJUST_LOWER,AudioManager.FLAG_PLAY_SOUND);
                seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
                Toast.makeText(MainActivity.this, "Down Volume", Toast.LENGTH_SHORT).show();
               // audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
            }
        });


    }
}