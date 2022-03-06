package com.epam.model;


public class Answer extends Entity {
    private int id;
    private String text;
    private String weight;
    private int questionId;

    public Answer() {
    }

    public Answer(int id, String text, String weight, int questionId) {
        this.id = id;
        this.text = text;
        this.weight = weight;
        this.questionId = questionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %d %n", getId(), getText(), getWeight(), getQuestionId());
    }
}
