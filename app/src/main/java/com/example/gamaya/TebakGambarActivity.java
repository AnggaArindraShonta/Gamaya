package com.example.gamaya;

import android.content.Intent;
import android.os.Bundle;

import com.example.gamaya.adapters.TebakGambarAdapter;
import com.example.gamaya.databinding.ActivityTebakGambarBinding;
import com.example.gamaya.utils.TebakGambarQuiz;
import com.example.gamaya.utils.ScoringUtil;

public class TebakGambarActivity extends BaseActivity {

    private ActivityTebakGambarBinding binding;
    private TebakGambarAdapter tebakGambarAdapter;
    private TebakGambarQuiz quiz;

    private int correctAnswer = 0;
    private int wrongAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTebakGambarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tebakGambarAdapter = new TebakGambarAdapter();
        quiz = new TebakGambarQuiz();

        binding.rvTebakGambarAnswer.setAdapter(tebakGambarAdapter);
        updateTebakGambar();
        tebakGambarAdapter.setOnItemClickListener((view, answerImgRes, answerPosition) -> {
            if (quiz.checkAnswer(answerPosition)) {
                correctAnswer++;
            }else {
                wrongAnswer++;
            }

            if (quiz.isLastPosition()) {
                Bundle bundle = new Bundle();
                bundle.putInt(ScoringUtil.WRONG_ANSWER_COUNT, wrongAnswer);
                bundle.putInt(ScoringUtil.CORRECT_ANSWER_COUNT, correctAnswer);
                bundle.putInt(ScoringUtil.RESULT_SCORE, ScoringUtil.calculateScore(correctAnswer, quiz.size()));
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
        if (quiz.isLastPosition()) return;

        quiz.increasePosition();
        updateTebakGambar();
    }

    private void updateTebakGambar() {
        binding.fabTebakGambarPositioning.setText("Tebak Gambar : " + quiz.currentNumber() + "/" + quiz.size());
        binding.tvQuestion.setText(quiz.getCurrentQuestion());
        tebakGambarAdapter.submitList(quiz.getCurrentChoices());
    }
}