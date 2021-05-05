package com.example.gamaya;

import android.os.Bundle;
import android.widget.Toast;

import com.example.gamaya.adapters.TebakGambarAdapter;
import com.example.gamaya.databinding.ActivityTebakGambarBinding;
import com.example.gamaya.utils.TebakGambarUtil;

public class TebakGambarActivity extends BaseActivity {

    private ActivityTebakGambarBinding binding;
    private TebakGambarAdapter tebakGambarAdapter;
    private int positioning = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTebakGambarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tebakGambarAdapter = new TebakGambarAdapter();

        binding.rvTebakGambarAnswer.setAdapter(tebakGambarAdapter);
        updateTebakGambar();
        tebakGambarAdapter.setOnItemClickListener((view, answerImgRes, answerPosition) -> {
            if ((positioning +1) >= TebakGambarUtil.getQuestions().length) return;
            if (answerPosition != TebakGambarUtil.getCorrectAnswer(positioning)) Toast.makeText(getApplicationContext(), "Jawaban Salah!!", Toast.LENGTH_SHORT).show();

            positioning++;
            updateTebakGambar();
        });
    }

    private void updateTebakGambar() {
        binding.fabTebakGambarPositioning.setText("Tebak Gambar : " + (positioning + 1) + "/" + TebakGambarUtil.getQuestions().length);
        binding.tvQuestion.setText(TebakGambarUtil.getQuestions(positioning));
        tebakGambarAdapter.submitList(TebakGambarUtil.getChoices(positioning));
    }
}