package com.example.gamaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuMateriActivity extends AppCompatActivity {

    ImageButton btnrumah, btnpakaian, btntarian, btnmusik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_materi);

        btnrumah = findViewById(R.id.btnrumah);
        btnpakaian = findViewById(R.id.btnpakaian);
        btntarian = findViewById(R.id.btntarian);
        btnmusik = findViewById(R.id.btnmusik);
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