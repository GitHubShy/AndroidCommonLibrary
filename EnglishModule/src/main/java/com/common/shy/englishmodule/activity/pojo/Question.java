package com.common.shy.englishmodule.activity.pojo;

public class Question {

    private String question;
    private String answer;
    private String userAnswer;
    private boolean isRight;

    public Question(String quesion, String answer) {
        this.question = quesion;
        this.answer = answer;
    }

    public String getQuesion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setUserAnswer(String userAnswer) {

        this.userAnswer = userAnswer;
    }

    public void setRight(boolean right) {
        isRight = right;
    }
}
