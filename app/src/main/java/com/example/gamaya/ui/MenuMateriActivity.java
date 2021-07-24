package com.example.gamaya.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.gamaya.R;

public class MenuMateriActivity extends AppCompatActivity {

    ImageButton btnrumah, btnpakaian, btntarian, btnmusik, btnkeragaman;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_materi);

        btnrumah = findViewById(R.id.btnrumah);
        btnpakaian = findViewById(R.id.btnpakaian);
        btntarian = findViewById(R.id.btntarian);
        btnmusik = findViewById(R.id.btnmusik);
        btnkeragaman = findViewById(R.id.btnkeragaman);
        btn_back = findViewById(R.id.btn_home);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuMateriActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btnkeragaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuMateriActivity.this, KeragamanActivity.class);
                startActivity(intent);
            }
        });
        btnrumah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuMateriActivity.this, RumahActivity.class);
                startActivity(intent);
            }
        });
        btnpakaian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuMateriActivity.this, PakaianActivity.class);
                startActivity(intent);
            }
        });
        btntarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuMateriActivity.this, TarianActivity.class);
                startActivity(intent);
            }
        });
        btnmusik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuMateriActivity.this, MusikActivity.class);
                startActivity(intent);
            }
        });
    }
}