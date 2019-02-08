package com.example.saraholoumi.multiplechoicequiz;

import java.util.ArrayList;

public class Question {
    private String mQuestion, mAnswer, mPossibleAnswerA,mPossibleAnswerB,mPossibleAnswerC,mPossibleAnswerD,mPossibleAnswerE;

    // This will return the simple name of a class like Question instead of com.exmaple.etc.etc.Question..
    // For more look at: https://www.tutorialspoint.com/java/lang/class_getsimplename.htm
    private static final String TAG = Question.class.getSimpleName();

    public Question(String question, String answer, String possibleAnswerA, String possibleAnswerB,
                    String possibleAnswerC, String possibleAnswerD, String possibleAnswerE)
    {
        mAnswer=answer;
        mQuestion=question;
        mPossibleAnswerA=possibleAnswerA;
        mPossibleAnswerB=possibleAnswerB;
        mPossibleAnswerC=possibleAnswerC;
        mPossibleAnswerD=possibleAnswerD;
        mPossibleAnswerE=possibleAnswerE;
    }

    // Getter for getting the question , answer, and possible answers
    public String getQuestion()
    {
        return mQuestion;
    }
    public String getAnswer()
    {
        return mAnswer;
    }
    public String getPossibleAnswerA()
    {
        return mPossibleAnswerA;
    }
    public String getPossibleAnswerB()
    {
        return mPossibleAnswerB;
    }
    public String getPossibleAnswerC()
    {
        return mPossibleAnswerC;
    }
    public String getPossibleAnswerD()
    {
        return mPossibleAnswerD;
    }
    public String getPossibleAnswerE()
    {
        return mPossibleAnswerE;
    }

    public static ArrayList<Question> multipleChoiceQuestionList()
    {
        ArrayList<Question> questionSet = new ArrayList<>();
        questionSet.add(new Question(
                "What version of JDK is required for this course?",
                "A",
                "[A] JDK 1.8",
                "[B] JDK 1.0",
                "[C] Java SE 10",
                "[D] Java SE 8",
                "[E] None"
        ));
        questionSet.add(new Question(
                "What does AVD stand for in android studio?",
                "C",
                "[A] Android Visual Debugger",
                "[B] Android Virtual Debugger",
                "[C] Android Virtual Device",
                "[D] Android Virtual Developer",
                "[E] None"
        ));
        questionSet.add(new Question(
                "Which of these keywords can be used to prevent Method overriding?",
                "E",
                "[A] Private",
                "[B] Public",
                "[C] Protected",
                "[D] Final",
                "[E] None"
        ));
        questionSet.add(new Question(
                "Java is a ________ programming language.",
                "D",
                "[A] World Wide Web Display",
                "[B] Declarative",
                "[C] Assembly",
                "[D] Object Oriented",
                "[E] None"
        ));
        questionSet.add(new Question(
                "What command do we use to compile Java Code from the terminal?",
                "D",
                "[A] compile",
                "[B] build",
                "[C] java",
                "[D] javac",
                "[E] None"
        ));
        questionSet.add(new Question(
                "In what folder do we access the XML files?",
                "A",
                "[A] res",
                "[B] generateJava",
                "[C] java",
                "[D] manifests",
                "[E] None"
        ));
        questionSet.add(new Question(
                "What is the file activity_main.xml used for?",
                "B",
                "[A] This is where you write your Java code.",
                "[B] Describes and configures what various UI components will be and how they will be positioned.",
                "[C] Describes and configures only what various UI components will.",
                "[D] Describes and configures only how various they will be positioned.",
                "[E] None"
        ));
        questionSet.add(new Question(
                "What are Linear Layouts?",
                "D",
                "[A] Enables you to specify the exact location of its children.",
                "[B] Group that displays child views in relative positions.",
                "[C] Group that displays a list of scrollable items.",
                "[D] Group that aligns all children in a single direction, vertically or horizontally.",
                "[E] None"
        ));
        questionSet.add(new Question(
                "What does DP stand for when adding padding/margins?",
                "C",
                "[A] Display profile",
                "[B] Density pixels",
                "[C] Density identity pixels",
                "[D] Display identity pixels",
                "[E] None"
        ));
        questionSet.add(new Question(
                "What type of inheritance does Java have?",
                "A",
                "[A] Class inheritance",
                "[B] Single inheritance",
                "[C] Object inheritance",
                "[D] Double inheritance",
                "[E] None"
        ));
        return questionSet;
    }
}
