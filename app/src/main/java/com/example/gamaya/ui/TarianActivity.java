package com.example.gamaya.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.gamaya.R;

public class TarianActivity extends AppCompatActivity {

    ImageButton btngambar, btnvideo;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarian);

        btn_back = findViewById(R.id.btn_home);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TarianActivity.this, MenuMateriActivity.class);
                startActivity(intent);
            }
        });

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