package com.example.gamaya.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

import com.example.gamaya.R;

public class SplashActivity extends AppCompatActivity {

    MediaPlayer audioBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Handler handler = new Handler();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Memanggil file my_sound pada folder raw
        audioBackground = MediaPlayer.create(this, R.raw.backsound);
        //Set looping ke true untuk mengulang audio jika telah selesai
        audioBackground.setLooping(true);
        //Set volume audio agar berbunyi
        audioBackground.setVolume(1,1);
        //Memulai audio
        audioBackground.start();

        handler.postDelayed(() -> {
            Intent i = new Intent(SplashActivity.this, ViewPagerActivity.class);
            finishAffinity();
            startActivity(i);
        }, 2500);
    }
}