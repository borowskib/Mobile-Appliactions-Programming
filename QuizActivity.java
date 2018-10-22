package com.example.borowskib.quizapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    // Declaration Variables

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private int mCurrentIndex;

    private Question[] mQuestionBank = new Question[]{

        new Question(R.string.question_stolica_polski, true),
        new Question(R.string.question_stolica_dolnego_slaska, true),
        new Question(R.string.question_sniezka, true),
        new Question(R.string.question_wisla, false),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Text View Function

        mQuestionTextView = (TextView) findViewById(R.id.QuestionTextView);

        // True Button Function

        mTrueButton = (Button) findViewById(R.id.TrueButton);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {checkAnswer(true);}
        });

        // False Button Function

        mFalseButton = (Button) findViewById(R.id.FalseButton);
        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {checkAnswer(false);}
        });

        // Next Button Function

        mNextButton = (Button) findViewById(R.id.NextButton);
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCurrentIndex = (mCurrentIndex +1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        updateQuestion();
    }


    // Update number of Question in Application Window

    public void updateQuestion()
    {
        int Question = mQuestionBank[mCurrentIndex].getTestResId();
        mQuestionTextView.setText(Question);
    }

    // Check the User's Answer

    public void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        if (userPressedTrue == answerIsTrue){
            mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
            updateQuestion();
        }
    }
}