package com.example.darts;

import java.util.Comparator;

public class Player {
    private int score;
    private String name;

    public Player(String name , int score){
        this.name = name;
        this.score = score;
    }

    int getScore(){
        return this.score;
    }
    void setScore(int val){
        score = val;
    }
    String getName() {
        return this.name;
    }
    void setName(String name) {
        this.name = name;
    }

    public static Comparator<Player> scoreCompare = new Comparator<Player>(){
        public int compare (Player p1, Player p2){

            int score1 = p1.getScore();
            int score2 = p2.getScore();
            return score2 - score1;
        }
    };
}



