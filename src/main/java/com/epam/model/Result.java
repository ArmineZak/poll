package com.epam.model;

public class Result {
    private int id;
    private String explanation;
    private int minScore;
    private int maxScore;
    private int pollId;

    public Result() {
    }

    public Result(String explanation) {
        this.explanation = explanation;
    }

    public Result(int id, String explanation, int minScore, int maxScore, int pollId) {
        this.id = id;
        this.explanation = explanation;
        this.minScore = minScore;
        this.maxScore = maxScore;
        this.pollId = pollId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getMinScore() {
        return minScore;
    }

    public void setMinScore(int minScore) {
        this.minScore = minScore;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public int getPollId() {
        return pollId;
    }

    public void setPollId(int pollId) {
        this.pollId = pollId;
    }

    @Override
    public String toString() {
        return String.format("%d %s %d %d %d %n", getId(), getExplanation(), getMinScore(),
                getMaxScore(), getPollId());
    }
}
