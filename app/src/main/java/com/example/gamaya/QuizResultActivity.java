package com.example.gamaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.example.gamaya.QuizActivity.hasil;

public class QuizResultActivity extends AppCompatActivity {

    FloatingActionButton home, kuncijawaban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        FloatingActionButton home = findViewById(R.id.home);
        FloatingActionButton kuncijawaban = findViewById(R.id.kuncijawabn);
        TextView nilai = findViewById(R.id.nilai);
        TextView hasil = findViewById(R.id.hasil);
        hasil.setText("Jawaban Benar :"+QuizActivity.benar+"\nJawaban Salah :"+QuizActivity.salah);
        nilai.setText(""+QuizActivity.hasil);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizResultActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        kuncijawaban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizResultActivity.this, KunciJawabanActivity.class);
                startActivity(intent);
            }
        });
    }


}