package com.quanteam.domain;

public class Player {

    private String name;
    private int score = 0;
    private int setScore = 0;
    private int tieBreakScore;


    public int getTieBreakScore() {
        return tieBreakScore;
    }


    public int getSetScore() {
        return setScore;
    }


    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSetScore(int setScore) {
        this.setScore = setScore;
    }

    public void setTieBreakScore(int tieBreakScore) {
        this.tieBreakScore = tieBreakScore;
    }
}
