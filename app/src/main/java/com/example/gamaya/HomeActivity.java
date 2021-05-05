package com.example.gamaya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    ImageButton btntebak, btneval, btnquiz, btnprofile, btnpetunjuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btntebak = findViewById(R.id.btntebak);
        btneval = findViewById(R.id.btneval);
        btnquiz = findViewById(R.id.btnquiz);
        btnprofile = findViewById(R.id.btnprofile);
        btnpetunjuk = findViewById(R.id.btnpetunjuk);
        btntebak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, TebakGambarActivity.class);
                startActivity(intent);
            }
        });
        btneval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, EvalActivity.class);
                startActivity(intent);
            }
        });
        btnquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, QuizActivity.class);
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