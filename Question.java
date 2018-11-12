package com.example.borowskib.quizapplication;

public class Question {
    private int mTestResId;
    private boolean mAnswerTrue;
    private boolean mQuestionAnswered;

    // Generated getters and setters - Methods
    // Fields of Class

    public Question(int textResId, boolean answerTrue,boolean questionAnswered){
        mTestResId = textResId;
        mAnswerTrue = answerTrue;
        mQuestionAnswered = questionAnswered;
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

    public boolean isQuestionAnswered(){
        return mQuestionAnswered;
    }
    public void setQuestionAnswered(boolean questionAnswered){
        mQuestionAnswered = questionAnswered;
    }

    public boolean getQuestionAnswered(){
        return mQuestionAnswered;
    }
}
