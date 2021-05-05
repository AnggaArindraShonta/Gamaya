package com.example.gamaya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    TextView quiz;
    RadioGroup radioGroup;
    RadioButton pilihanA, pilihanB, pilihanC, pilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //Pertanyaan
    String[] pertanyaan_quiz = new String[]{
            "1.	Keberagman adat yang ada di Indonesia harus dimaknai sebagai ...",
            "2. Indonesia mempunyai keragaman rumah adat di setiap daerah antara lain karena Indonesia mempunyai ...",
            "3. Berikut yang bukan bagian dari keberagaman budaya Indonesia adalah ",
            "4. Betang, Joglo dan Gadang adalah contoh kergaman budaya Indonesia berupa ... ",
            "5. Pakaian adat berikut ini yang tidak berasal dari daerah di pulau Sulawesi adalah ...",
            "6. Contoh tarian di Indonesia dengan pola lingkaran adalah ...",
            "7. Pasangan pakaian adat di bawah ini yang tepat sesuai daerah asalnya adalah ...",
            "8. Kolintang merupakan alat musik yang berasal dari daerah ...",
            "9. Pasangan tarian di bawah ini yang tepat sesuai daerah asalnya adalah ...",
            "10. Honai merupakan rumah adat yang berasal dari daerah "
    };

    //Pilihan Jawaban a, b, c, d
    String[] pilihan_jawaban = new String[]{
            "Kemunduran bangsa", "Kelemahan bangsa", "Kejatuhan bangsa", "Kekayaan bangsa",
            "Beragam warna kulit", "Beragam suku  bangsa", "Banyak gunung berapi", "Laut yang  luas",
            "Tarian daerah", "Rumah Adat", "Pakaian adat ", "Tanah Daerah",
            "Pakaian adat", "Tarian daerah", "Lagu daerah", "Rumah adat",
            "Laku Tepu", "Baju Bodo ", "Payas Agung", "Nggembe",
            "Tari Kecak", "Tari Saman", "Tari Saman", "Tari Remo",
            "Ulee Balang dari Jawa Barat", "Ulos dari Sumatra Utara", "Koteka dari Maluku ", "Paksian dari Jawa Barat",
            "Jawa Tengah", "Jambi ", "Sulawesi Utara", "Sumatera Selatan",
            "Tari Topeng dari Jawa Timur", "Tari  Saman dari Maluku Utara", "Tari Piring dari Kalimantan Selatan", "Tari Kipas dari Sulawesi Selatan",
            "Kalimantan Barat ", "Papua", "Bali", "Bali"
    };

    //Jawaban Benar
    String[] jawaban_benar = new String[]{
            "Kekayaan bangsa",
            "Beragam suku  bangsa",
            "Tanahdaerah",
            "Rumah adat",
            "Payas Agung",
            "Tari Kecak",
            "Ulos dari Sumatra Utara",
            "Sulawesi Utara",
            "Tari Kipas dari Sulawesi Selatan",
            "Papua"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quiz = findViewById(R.id.quiz);
        radioGroup = findViewById(R.id.pilihan);
        pilihanA = findViewById(R.id.pilihanA);
        pilihanB = findViewById(R.id.pilihanB);
        pilihanC = findViewById(R.id.pilihanC);
        pilihanD = findViewById(R.id.pilihanD);

        quiz.setText(pertanyaan_quiz[nomor]);
        pilihanA.setText(pilihan_jawaban[0]);
        pilihanB.setText(pilihan_jawaban[1]);
        pilihanC.setText(pilihan_jawaban[2]);
        pilihanD.setText(pilihan_jawaban[3]);

        radioGroup.check(0);
        benar = 0;
        salah = 0;
    }

    public void next(View view){
        if (pilihanA.isChecked() || pilihanB.isChecked() || pilihanC.isChecked() || pilihanD.isChecked()) {

            RadioButton jawaban_user = findViewById(radioGroup.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            radioGroup.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan_quiz.length) {
                quiz.setText(pertanyaan_quiz[nomor]);
                pilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                pilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                pilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                pilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);
            } else {
                hasil = benar * 10;
                Intent intent = new Intent(getApplicationContext(), QuizResultActivity.class);
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "Jawaban tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
    }
}