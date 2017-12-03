package com.quanteam.domain;

public class Player {

    String name;
    int score =0;

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
}