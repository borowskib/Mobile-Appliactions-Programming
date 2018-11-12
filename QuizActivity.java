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

    int CurrentPoints = 0;
    int QuestionAnswerStatus = 0;

    private Question[] mQuestionBank = new Question[]{

        new Question(R.string.question_stolica_polski, true, false),
        new Question(R.string.question_stolica_dolnego_slaska, true, false),
        new Question(R.string.question_sniezka, false, false),
        new Question(R.string.question_wisla, false,false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Text View Function

        mQuestionTextView = (TextView) findViewById(R.id.QuestionTextView);
        mQuestionTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (mCurrentIndex != mQuestionBank.length - 1) {
                    mCurrentIndex += 1;
                    updateQuestion();
                } else if (QuestionAnswerStatus == mQuestionBank.length) {
                    showScore();
                } else { }
            }
        });

        // True Button Function

        mTrueButton = (Button) findViewById(R.id.TrueButton);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mQuestionBank[mCurrentIndex].getQuestionAnswered()==true){
                    sendMessageAnswered();
                }
                else {checkAnswer(true);}
            }
        });

        // False Button Function

        mFalseButton = (Button) findViewById(R.id.FalseButton);
        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mQuestionBank[mCurrentIndex].getQuestionAnswered()==true){
                    sendMessageAnswered();
                }
                else {checkAnswer(false);
                }
            }
        });

        // Next Button Function

        mNextButton = (ImageButton) findViewById(R.id.NextButton);
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mCurrentIndex != mQuestionBank.length - 1){
                    mCurrentIndex +=1;
                    updateQuestion();
                }
                else if(QuestionAnswerStatus == mQuestionBank.length){
                    showScore();
                }
                else { }
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
        if(mQuestionBank[mCurrentIndex].getQuestionAnswered()==false) {
            if (userPressedTrue == answerIsTrue) {
                messageResId = R.string.goodAnswer;
                CurrentPoints += 1;
                questionAnswerIsTrue();
            } else {
                messageResId = R.string.wrongAnswer;
                questionAnswerIsTrue();
            }
        }

        // Make Toast

        Toast message = Toast.makeText(this,messageResId, Toast.LENGTH_SHORT);
        message.setGravity(Gravity.TOP, 0, 250);
        message.show();

    }

    // Check Status Question of Answer

    public void questionAnswerIsTrue(){
        mQuestionBank[mCurrentIndex].setQuestionAnswered(true);
        QuestionAnswerStatus += 1;
    }

    // Send Message If Answered

    public void sendMessageAnswered(){
        Toast.makeText(this,"Na to pytanie została już udzielona odpowiedź !", Toast.LENGTH_SHORT).show();
    }

    // Show Score After End of Questions

    public void showScore(){
        Toast.makeText(this,"Zdobyte punkty: " + CurrentPoints,Toast.LENGTH_SHORT).show();
    }
}