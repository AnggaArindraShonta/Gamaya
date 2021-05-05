package com.example.gamaya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gamaya.databinding.ActivityQuizResultBinding;
import com.example.gamaya.utils.ScoringUtil;

public class QuizResultActivity extends AppCompatActivity {

    private ActivityQuizResultBinding binding;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bundle = getIntent().getExtras();

        binding.btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizResultActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.btnKunciJawaban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizResultActivity.this, KunciJawabanActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        int correctCount = bundle.getInt(ScoringUtil.CORRECT_ANSWER_COUNT);
        int wrongCount = bundle.getInt(ScoringUtil.WRONG_ANSWER_COUNT);
        int unansweredCount = bundle.getInt(ScoringUtil.UNANSWERED_COUNT);
        int resultScore = bundle.getInt(ScoringUtil.RESULT_SCORE);

        binding.tvResultTotal.setText(String.valueOf(resultScore));
        binding.tvUnansweredCount.setText(String.valueOf(unansweredCount));
        binding.tvCorrectCount.setText(String.valueOf(correctCount));
        binding.tvWrongCount.setText(String.valueOf(wrongCount));
    }
}