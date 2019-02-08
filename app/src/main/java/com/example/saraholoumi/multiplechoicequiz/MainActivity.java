package com.example.saraholoumi.multiplechoicequiz;


import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button mNextButton, mPreviousButton, mSubmitButton,mButtonA, mButtonB, mButtonC, mButtonD, mButtonE;
    private int qIndex=0;
    public static int score = 0;
    private TextView mQuizQuestionsTextView, mPossibleAnswerATextView, mPossibleAnswerBTextView, mPossibleAnswerCTextView,
            mPossibleAnswerDTextView, mPossibleAnswerETextView, mScoreTextView;
    private ArrayList<Question> questionSet;
    private String [] userAnswers;
    private static String QUESTION_INDEX_KEY = "question_index";
    private static String USER_ANSWERS_KEY = "user_answers_key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mQuizQuestionsTextView = findViewById(R.id.question_defintion_view);
        mPossibleAnswerATextView = findViewById(R.id.option_A);
        mPossibleAnswerBTextView = findViewById(R.id.option_B);
        mPossibleAnswerCTextView = findViewById(R.id.option_C);
        mPossibleAnswerDTextView = findViewById(R.id.option_D);
        mPossibleAnswerETextView = findViewById(R.id.option_E);
        mScoreTextView = findViewById(R.id.final_score);

        mButtonA = (findViewById(R.id.buttonA));
        mButtonA.setOnClickListener(this);
        mButtonA.setText("A");
        mButtonB = findViewById(R.id.buttonB);
        mButtonB.setOnClickListener(this);
        mButtonB.setText("B");
        mButtonC = findViewById(R.id.buttonC);
        mButtonC.setOnClickListener(this);
        mButtonC.setText("C");
        mButtonD = findViewById(R.id.buttonD);
        mButtonD.setOnClickListener(this);
        mButtonD.setText("D");
        mButtonE = findViewById(R.id.buttonE);
        mButtonE.setOnClickListener(this);
        mButtonE.setText("E");

        mNextButton = findViewById(R.id.next_button);
        mNextButton.setOnClickListener(this);
        mPreviousButton = findViewById(R.id.previous_button);
        mPreviousButton.setOnClickListener(this);
        mSubmitButton = findViewById(R.id.submit_button);
        mSubmitButton.setOnClickListener(this);


        questionSet = null;



        ArrayList<Question> parsedModel = null;
        try {
            InputStream iStream = getResources().openRawResource(R.raw.quiz_questions);
            BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream));
            parsedModel = Quiz.pullParseFrom(bReader);
            bReader.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();

        }
        if (parsedModel == null || parsedModel.isEmpty()) {
            Log.i(TAG, "ERROR: Questions Not Parsed");
        }
        questionSet = parsedModel;
        userAnswers = new String[questionSet.size()];
        if (savedInstanceState != null) {
            qIndex = savedInstanceState.getInt(QUESTION_INDEX_KEY, 0);
            userAnswers = savedInstanceState.getStringArray(USER_ANSWERS_KEY);
        }


        if (questionSet != null && questionSet.size() > 0) {
            mQuizQuestionsTextView.setText((qIndex + 1) + ") " + questionSet.get(qIndex).getQuestion());
            mPossibleAnswerATextView.setText("" + questionSet.get(qIndex).getPossibleAnswerA());
            mPossibleAnswerBTextView.setText("" + questionSet.get(qIndex).getPossibleAnswerB());
            mPossibleAnswerCTextView.setText("" + questionSet.get(qIndex).getPossibleAnswerC());
            mPossibleAnswerDTextView.setText("" + questionSet.get(qIndex).getPossibleAnswerD());
            mPossibleAnswerETextView.setText("" + questionSet.get(qIndex).getPossibleAnswerE());
        }

        setSelectedButtons();
    }

    private void setSelectedButtons()
    {
        mButtonA.setBackgroundColor(getColor(R.color.grey));
        mButtonB.setBackgroundColor(getColor(R.color.grey));
        mButtonC.setBackgroundColor(getColor(R.color.grey));
        mButtonD.setBackgroundColor(getColor(R.color.grey));
        mButtonE.setBackgroundColor(getColor(R.color.grey));
        if(userAnswers[qIndex]!=null)
        {
            String userAnswer = userAnswers[qIndex];
            if(userAnswer.equals("A"))
            {
                mButtonA.setBackgroundColor(getColor(R.color.light_orange));
            }
            else if (userAnswer.equals("B"))
            {
                mButtonB.setBackgroundColor(getColor(R.color.light_orange));
            }
            else if(userAnswer.equals("C"))
            {
                mButtonC.setBackgroundColor(getColor(R.color.light_orange));
            }
            else if(userAnswer.equals("D"))
            {
                mButtonD.setBackgroundColor(getColor(R.color.light_orange));
            }
            else
            {
                mButtonE.setBackgroundColor(getColor(R.color.light_orange));
            }
        }
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(QUESTION_INDEX_KEY, qIndex);
        savedInstanceState.putStringArray(USER_ANSWERS_KEY,userAnswers);
        Log.i(TAG, "onSaveInstanceState(Bundle)");
    }

    @Override
    public void onClick(View v)
    {
        Button buttonClicked = (Button) v;

        switch (v.getId()){
        case R.id.buttonA:
            userAnswers[qIndex]= "A";
            if (questionSet.get(qIndex).getAnswer().equals("A"))
            {
                    score++;
                    mButtonA.isPressed();
                } else {
                    Log.i(TAG, "user put in the wrong answer");
                }
                break;
        case R.id.buttonB:
            userAnswers[qIndex]= "B";
            if (questionSet.get(qIndex).getAnswer().equals("B"))
            {
                score++;
            } else {
                Log.i(TAG, "user put in the wrong answer");
            }
            break;

        case R.id.buttonC:
            userAnswers[qIndex]= "C";
            if (questionSet.get(qIndex).getAnswer().equals("C"))
            {
                score++;
            } else {
                Log.i(TAG, "user put in the wrong answer");
            }
            break;

        case R.id.buttonD:
            userAnswers[qIndex]= "D";
            if (questionSet.get(qIndex).getAnswer().equals("D"))
            {
                score++;
            } else {
                Log.i(TAG, "user put in the wrong answer");
            }
            break;

        case R.id.buttonE:
            userAnswers[qIndex]= "E";
            if (questionSet.get(qIndex).getAnswer().equals("E"))
            {
                score++;
            } else {
                Log.i(TAG, "user put in the wrong answer");
            }
            break;
        case R.id.previous_button:
            if (qIndex > 0) {
                qIndex--;
            }
            mQuizQuestionsTextView.setText((qIndex + 1) + ") " + questionSet.get(qIndex).getQuestion());
            mPossibleAnswerATextView.setText("" + questionSet.get(qIndex).getPossibleAnswerA());
            mPossibleAnswerBTextView.setText("" + questionSet.get(qIndex).getPossibleAnswerB());
            mPossibleAnswerCTextView.setText("" + questionSet.get(qIndex).getPossibleAnswerC());
            mPossibleAnswerDTextView.setText("" + questionSet.get(qIndex).getPossibleAnswerD());
            mPossibleAnswerETextView.setText("" + questionSet.get(qIndex).getPossibleAnswerE());

            break;

        case R.id.next_button:
            if (qIndex >= 0)
            {
                qIndex++;
            }
            if(qIndex==questionSet.size())
            {
                qIndex=0;
            }
            mQuizQuestionsTextView.setText((qIndex + 1) + ") " + questionSet.get(qIndex).getQuestion());
            mPossibleAnswerATextView.setText("" + questionSet.get(qIndex).getPossibleAnswerA());
            mPossibleAnswerBTextView.setText("" + questionSet.get(qIndex).getPossibleAnswerB());
            mPossibleAnswerCTextView.setText("" + questionSet.get(qIndex).getPossibleAnswerC());
            mPossibleAnswerDTextView.setText("" + questionSet.get(qIndex).getPossibleAnswerD());
            mPossibleAnswerETextView.setText("" + questionSet.get(qIndex).getPossibleAnswerE());

            break;

        case R.id.submit_button:
            System.out.println("Score: " + score + "/10");
            mScoreTextView.setText("Score: " + score + "/10");
            new Handler().postDelayed(() -> mScoreTextView.setText(""), 2000);
            userAnswers = new String[questionSet.size()];
            score=0;
            qIndex=0;
            mQuizQuestionsTextView.setText((qIndex + 1) + ") " + questionSet.get(qIndex).getQuestion());
            mPossibleAnswerATextView.setText("" + questionSet.get(qIndex).getPossibleAnswerA());
            mPossibleAnswerBTextView.setText("" + questionSet.get(qIndex).getPossibleAnswerB());
            mPossibleAnswerCTextView.setText("" + questionSet.get(qIndex).getPossibleAnswerC());
            mPossibleAnswerDTextView.setText("" + questionSet.get(qIndex).getPossibleAnswerD());
            mPossibleAnswerETextView.setText("" + questionSet.get(qIndex).getPossibleAnswerE());
            break;
        }

        setSelectedButtons();
    }

}





