package com.example.gamaya.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gamaya.R;

public class HomeActivity extends AppCompatActivity {

    ImageButton btntebak, btneval, btnmateri, btnprofile, btnpetunjuk, btnkompetensi, btnpustaka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btntebak = findViewById(R.id.btntebak);
        btneval = findViewById(R.id.btneval);
        btnmateri = findViewById(R.id.btnmateri);
        btnprofile = findViewById(R.id.btnprofile);
        btnpetunjuk = findViewById(R.id.btnpetunjuk);
        btnkompetensi = findViewById(R.id.btnkompetensi);
        btnpustaka = findViewById(R.id.btnpustaka);
        btnpustaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PustakaActivity.class);
                startActivity(intent);
            }
        });
        btntebak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, TebakGambarActivity.class);
                startActivity(intent);
            }
        });
        btnkompetensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, KompetensiActivity.class);
                startActivity(intent);
            }
        });
        btneval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });
        btnmateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MenuMateriActivity.class);
                startActivity(intent);
            }
        });
        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        btnpetunjuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PetunjukActivity.class);
                startActivity(intent);
            }
        });
    }
}