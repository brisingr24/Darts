package com.example.darts;

import java.util.ArrayList;
import java.util.Collections;

public class GameEngine {
    private int ct = 1;
    private int j=-1;
    private int number;
    private int rounds;
    private ArrayList<Player> players = new ArrayList<Player>();
    private int currentRound;
    private int currentPlayerIndex;

    public GameEngine(int number, int rounds, ArrayList<String> name) {
        this.number = number;
        this.rounds = rounds;
        this.currentPlayerIndex = 0;
        this.currentRound = 0;
        for(int i = 0; i<number ; i++)
        {
            Player player = new Player(name.get(i) , 0);
            this.players.add(player);
        }
    }

    int getScorePlayer(int ogIndex){
//        if(ogIndex == -1)
//        {
//            Player currentPlayer = players.get(currentPlayerIndex);
//            currentPlayerIndex++;
//            return currentPlayer.getScore();
//        }
        Player currentPlayer = players.get(ogIndex);
        return currentPlayer.getScore();
    }
    public int nextTurn(int currentScore){
        if(rounds == 0)
            return -1;
        Player currentPlayer = players.get(currentPlayerIndex);
        int newScore = currentPlayer.getScore() + currentScore;
        currentPlayer.setScore(newScore);
        int tempIndex = currentPlayerIndex;
        incrementPlayerIndex();
        return tempIndex;
    }
    void incrementPlayerIndex(){
        currentPlayerIndex++;
        if(currentPlayerIndex == number){
            currentPlayerIndex = 0;
            rounds--;
        }
    }
    int nextName(){
        return currentPlayerIndex;
    }

    public int round(){
        if(currentPlayerIndex == 0)
            ct++;
        return ct;
    }

         public Player winner(){
                Collections.sort(players, Player.scoreCompare);
                j++;
                return players.get(j);
        }
}
