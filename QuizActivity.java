package com.example.borowskib.quizapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    // Declaration Variables

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPreviousButton;
    private TextView mQuestionTextView;
    private int mCurrentIndex;

    private Question[] mQuestionBank = new Question[]{

        new Question(R.string.question_stolica_polski, true),
        new Question(R.string.question_stolica_dolnego_slaska, true),
        new Question(R.string.question_sniezka, false),
        new Question(R.string.question_wisla, false),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Text View Function

        mQuestionTextView = (TextView) findViewById(R.id.QuestionTextView);
        mQuestionTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCurrentIndex =(mCurrentIndex +1) % mQuestionBank.length;
                updateQuestion();
            }
        });

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

        mNextButton = (ImageButton) findViewById(R.id.NextButton);
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCurrentIndex = (mCurrentIndex +1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        // Previous Button Function

        mPreviousButton = (ImageButton) findViewById(R.id.PreviousButton);
        mPreviousButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mCurrentIndex != 0){
                mCurrentIndex = (mCurrentIndex -1) % mQuestionBank.length;
                updateQuestion();
                }
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

        int messageResId = 0;
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        if (userPressedTrue == answerIsTrue){
            messageResId = R.string.goodAnswer;
            mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
            updateQuestion();
        }
        else {
            messageResId = R.string.wrongAnswer;
        }

        // Make Toast
        Toast message = Toast.makeText(this,messageResId, Toast.LENGTH_SHORT);
        message.setGravity(Gravity.TOP, 0, 250);
        message.show();

    }
}