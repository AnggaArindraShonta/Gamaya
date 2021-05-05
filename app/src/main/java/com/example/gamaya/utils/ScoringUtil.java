package com.example.gamaya.utils;

public class ScoringUtil {

    public static final String CORRECT_ANSWER_COUNT = "correct_answer_count";
    public static final String WRONG_ANSWER_COUNT = "wrong_answer_count";
    public static final String UNANSWERED_COUNT = "unanswered_count";
    public static final String RESULT_SCORE = "result_score";

    public static int calculateScore(int totalCorrectAnswer, int length){
        return (int) ((100.0 * totalCorrectAnswer) / length);
    }

    public static class TebakGambar {
        public static int correctAnswer = 0;
        public static int wrongAnswer = 0;
    }
}
