package com.example.saraholoumi.multiplechoicequiz;

import java.io.BufferedReader;
import java.util.ArrayList;

public class Quiz
{
    public static final String XML_QUIZ = "quiz";
    private static final String TAG = Quiz.class.getSimpleName();

    public static ArrayList<Question> pullParseFrom(BufferedReader reader){

        ArrayList<Question> questionSet = Question.multipleChoiceQuestionList();

        return questionSet;

    }
}
