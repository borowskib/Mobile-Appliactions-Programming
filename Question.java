package com.example.borowskib.quizapplication;

public class Question {
    private int mTestResId;
    private boolean mAnswerTrue;

    // Generated getters and setters
    public Question(int textRestId, boolean answerTrue){
        mTestResId = textRestId;
        mAnswerTrue = answerTrue;
    }

    public int getTestResId(){
        return mTestResId;
    }

    public void setTestResId(int testResId){
        mTestResId = testResId;
    }

    public boolean isAnswerTrue(){
        return mAnswerTrue;
    }

    public void setmAnswerTrue(boolean answerTrue){
        mAnswerTrue = answerTrue;
    }

}
