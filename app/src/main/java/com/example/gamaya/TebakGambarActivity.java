package com.example.gamaya;

import android.content.Intent;
import android.os.Bundle;

import com.example.gamaya.adapters.TebakGambarAdapter;
import com.example.gamaya.databinding.ActivityTebakGambarBinding;
import com.example.gamaya.utils.ScoringUtil;
import com.example.gamaya.utils.TebakGambarUtil;

public class TebakGambarActivity extends BaseActivity {

    private ActivityTebakGambarBinding binding;
    private TebakGambarAdapter tebakGambarAdapter;
    private int positioning = 0;
    private int correctAnswer = 0;
    private int wrongAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTebakGambarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tebakGambarAdapter = new TebakGambarAdapter();

        binding.rvTebakGambarAnswer.setAdapter(tebakGambarAdapter);
        updateTebakGambar();
        tebakGambarAdapter.setOnItemClickListener((view, answerImgRes, answerPosition) -> {
            if (answerPosition == TebakGambarUtil.getCorrectAnswer(positioning)) {
                correctAnswer++;
            }else {
                wrongAnswer++;
            }

            if ((positioning +1) >= TebakGambarUtil.getQuestions().length) {
                Bundle bundle = new Bundle();
                bundle.putInt(ScoringUtil.WRONG_ANSWER_COUNT, wrongAnswer);
                bundle.putInt(ScoringUtil.CORRECT_ANSWER_COUNT, correctAnswer);
                bundle.putInt(ScoringUtil.RESULT_SCORE, ScoringUtil.calculateScore(correctAnswer, TebakGambarUtil.getQuestions().length));
                Intent intent = new Intent(getApplicationContext(), QuizResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                return;
            }

            nextQuestion();
        });
    }

    private void nextQuestion() {
        if ((positioning +1) >= TebakGambarUtil.getQuestions().length) return;

        positioning++;
        updateTebakGambar();
    }

    private void updateTebakGambar() {
        binding.fabTebakGambarPositioning.setText("Tebak Gambar : " + (positioning + 1) + "/" + TebakGambarUtil.getQuestions().length);
        binding.tvQuestion.setText(TebakGambarUtil.getQuestions(positioning));
        tebakGambarAdapter.submitList(TebakGambarUtil.getChoices(positioning));
    }
}