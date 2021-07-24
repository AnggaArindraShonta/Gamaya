package com.example.gamaya.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gamaya.utils.BaseActivity;
import com.example.gamaya.R;
import com.example.gamaya.utils.ScoringUtil;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class QuizActivity extends BaseActivity {

    TextView quiz;
    RadioGroup radioGroup;
    RadioButton pilihanA, pilihanB, pilihanC, pilihanD;

    ImageButton btnBack;

    int nomor = 0;
    public static int hasil, benar, salah;

    //Pertanyaan
    String[] pertanyaan_quiz = new String[]{
            "1.	Alita dan Ifa berasal dari daerah yang berbeda. Alita berasal dari daerah yang bentang alamnya berupa pegunungan. Ifa berasal dari daerah pesisir pantai. Keduanya memiliki kebiasaan dan budaya yang berbeda. Faktor yang menyebabkan adanya ragam budaya di antara keduanya adalah ...",
            "2. Mengenakan pakaian adat dari daerah masing-masing merupakan keragaman yang menunjukkan adanya perbedaan ...",
            "3. Walau memiliki banyak keberagaman dan perbedaan, namun bangsa Indonesia tetap bersatu seperti dalam semboyan ...",
            "4. Pasangan pakaian adat di bawah ini yang tepat sesuai daerah asalnya adalah ...",
            "5. Pakaian adat berikut ini yang tidak berasal dari daerah pulau Sulawesi adalah ...",
            "6. Honai merupakan rumah adat yang berasal dari daerah ...",
            "7. Tarian ini merupakan tarian tradisonal suku Dayak yang dilakukan untuk memohon penyembuhan kepada Tuhan agar warga yang sakit di berikan kesembuhan. Namun seiring dengan perkembangan jaman, tarian ini tidak hanya di gunakan sebagai tarian penyembuhan saja, namun juga sebagai sarana hiburan sebagai pelestarian kesenian tradisional suku Dayak. Nama tarian yang di maksud adalah ...",
            "8. Kolintang merupakan alat musik yang berasal dari daerah ...",
            "9. Salah satu tarian paling populer dari provinsi Sumatera Utara. Tarian ini biasanya ditarikan oleh orang Batak dalam berbagai ritual penting seperti pesta pernikahan, pesta kematian, syukuran panen hingga upacara penyembuhan orang sakit. Nama tarian tersebut adalah ...",
            "10. Perhatikan pernyataan-pernyataan berikut !\n" +
                    "(1) Menonjolkan suku, agama, ras, dan golongan sendiri.\n" +
                    "(2) Acuh tak acuh terhadap perbedaan dalam masyarakat.\n" +
                    "(3) Menganggap hanya suku sendiri yang paling bagus dan suku lainnya jelek.\n" +
                    "(4) Meningkatkan interaksi tanpa mempermasalahkan perbedaan.\n" +
                    "Sikap menghargai keragaman budaya masyarakat Indonesia ditunjukkan pada nomor ...\n"
    };

    //Pilihan Jawaban a, b, c, d
    String[] pilihan_jawaban = new String[]{
            "Ras asal", "Lingkungan geografis", "Latar belakang sejarah", "Perbedaan kepercayaan",
            "Suku", "Kegemaran", "Jenis kelamin", "Agama",
            "Bhineka Tunggal Ika", "Tut Wuri Handayani", "Ing Ngarsa Sung Tuladha", "Negara kertagama",
            "Ulee Balang dari Jawa Barat", "Ulos dari Sumatra Utara ", "Koteka dari Maluku ", "Paksian dari Jawa Barat",
            "Laku Tepu", "Baju Bodo ", "Payas Agung", "Nggembe",
            "Kalimantan Barat ", "Papua ", "Bali ", "Riau ",
            "Tari Baksa Kembang ", "Tari Pendet ", "Tari Kipas ", "Tari Monong ",
            "Jawa Tengah ", "Jambi ", "Sulawesi Utara ", "Sumatera Selatan ",
            "Tari Tor – Tor ", "Tari Piring ", "Tari Gambyong ", "Tari Baksa Kembang ",
            "(1)", "(2)", "(3)", "(4)"
    };

    //Jawaban Benar
    String[] jawaban_benar = new String[]{
            "Lingkungan geografis",
            "Suku",
            "Bhineka Tunggal Ika",
            "Ulos dari Sumatra Utara ",
            "Payas Agung",
            "Papua ",
            "Tari Monong ",
            "Sulawesi Utara",
            "Tari Tor – Tor ",
            "(4)"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quiz = findViewById(R.id.quiz);
        radioGroup = findViewById(R.id.pilihan);
        btnBack = findViewById(R.id.btn_back);
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

        btnBack.setOnClickListener(v -> {
            new MaterialAlertDialogBuilder(this)
                    .setTitle("Keluar Dari Quiz")
                    .setMessage("Anda yakin ingin mengakhiri Quiz?")
                    .setPositiveButton("Keluar", (dialog, which) -> onBackPressed())
                    .setNegativeButton("Lanjut Quiz", (dialog, which) -> dialog.dismiss())
                    .create()
                    .show();
        });
    }

    public void next(View view){
        if (pilihanA.isChecked() || pilihanB.isChecked() || pilihanC.isChecked() || pilihanD.isChecked()) {

            RadioButton jawaban_user = findViewById(radioGroup.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            radioGroup.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) {
                benar++;
                shortToast("Yeay, Jawaban Kamu Benar! :)");
            }
            else {
                salah++;
                shortToast("Maaf, Jawaban Kamu Salah! :(");
            }
            nomor++;
            if (nomor < pertanyaan_quiz.length) {
                quiz.setText(pertanyaan_quiz[nomor]);
                pilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                pilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                pilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                pilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);
            } else {
                Bundle bundle = new Bundle();
                bundle.putInt(ScoringUtil.WRONG_ANSWER_COUNT, salah);
                bundle.putInt(ScoringUtil.CORRECT_ANSWER_COUNT, benar);
                bundle.putInt(ScoringUtil.RESULT_SCORE, ScoringUtil.calculateScore(benar, pertanyaan_quiz.length));
                Intent intent = new Intent(getApplicationContext(), QuizResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "Jawaban tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
    }
}