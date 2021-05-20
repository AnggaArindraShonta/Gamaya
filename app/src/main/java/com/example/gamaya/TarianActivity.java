package com.example.gamaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class TarianActivity extends AppCompatActivity {

    ImageButton btngambar, btnvideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarian);

        btngambar = findViewById(R.id.btngambar);
        btnvideo = findViewById(R.id.btnvideo);
        btngambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TarianActivity.this, GambarTarianActivity.class);
                startActivity(intent);
            }
        });
        btnvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TarianActivity.this, EvalActivity.class);
                startActivity(intent);
            }
        });
    }
}