package com.example.gamaya.utils;

public class TebakGambarQuiz {

    private int currentPosition = 0;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int currentNumber() {
        return currentPosition+1;
    }

    public void increasePosition(){
        if (currentPosition >= lastPosition()) return;
        currentPosition++;
    }

    public void decreasePosition(){
        if (currentPosition <= startPosition()) return;
        currentPosition--;
    }

    public int startPosition() {
        return 0;
    }

    public int lastPosition() {
        return TebakGambarStore.getQuestions().length - 1;
    }

    public boolean isLastPosition(){
        return currentPosition == lastPosition();
    }

    public int size(){
        return TebakGambarStore.getQuestions().length;
    }

    public String getCurrentQuestion(){
        return TebakGambarStore.getQuestions(currentPosition);
    }

    public int[] getCurrentChoices(){
        return TebakGambarStore.getChoices(currentPosition);
    }

    public int getCurrentCorrectAnswer(){
        return TebakGambarStore.getCorrectAnswer(currentPosition);
    }

    public boolean checkAnswer(int answerPosition){
        return answerPosition == getCurrentCorrectAnswer();
    }

}
