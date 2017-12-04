package com.quanteam.domain;

public class Player {

    private String name;
    private int score =0;
    private int setScore=0;

    public int getSetScore() {
        return setScore;
    }

    public void winPoint(){
        this.score +=1 ;
    }

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
