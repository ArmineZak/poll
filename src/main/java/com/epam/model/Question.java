package com.epam.model;

public class Question extends Entity {
    private int id;
    private String text;
    private String pollId;

    public Question() {
    }

    public Question(int id) {
        this.id = id;
    }

    public Question(String text) {
        this.text = text;
    }

    public Question(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public Question(int id, String text, String pollId) {
        this.id = id;
        this.text = text;
        this.pollId = pollId;
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

    public String getPollId() {
        return pollId;
    }

    public void setPollId(String pollId) {
        this.pollId = pollId;
    }

    @Override
    public String toString() {
        return String.format("%d %s %d %n", getId(), getText(), getPollId());
    }
}