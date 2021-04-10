package com.example.darts;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class Darts3 extends AppCompatActivity {

    TextView textView;
    TextView textView1;
    private Button button4;
    private int rounds,number;
    private ArrayList<String> name;
    private ArrayList<TextView> scoreTextViewArray = new ArrayList<TextView>();
    private GameEngine session;
    private ArrayList<String> playerList = new ArrayList<String>();
    private ArrayList<String> scoreList = new ArrayList<String>();
    private  Player b;
    private String score;
    private String winner;
    private int currentRound;

    public static final String EXTRA_NUMBER1 = "com.example.application.example.EXTRA_NUMBER1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darts3);

        Intent intent = getIntent();
        number = intent.getIntExtra(Darts1.EXTRA_NUMBER1,0);
        rounds = intent.getIntExtra(Darts1.EXTRA_NUMBER2,0);

        textView = findViewById(R.id.playername);
        name = intent.getStringArrayListExtra("key");
        textView.setText(String.valueOf(name.get(0)));
        textView1 = findViewById(R.id.Round);
        String y = "Round 1 of "+rounds;
        textView1.setText(y);

        EditText points;
        // set textview with player 1
        // create edit text.

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            // extract score from editext.. store in currentscore
            // pass current score to nextTurn().
            // getPlayerScore with index in above line
            // set this score in correct element of textview array.
            // call String getNextPlayer(currentIndex) gives next player name.
            // set text view to next player
            EditText points = (EditText) findViewById(R.id.points);
            int currentScore = Integer.parseInt(points.getText().toString());
            points.setText("");

            int ogIndex = session.nextTurn(currentScore);
            if(ogIndex == -1)
            {
                for(int i = 0; i<number; i++)
                {
                    b = session.winner();
                    score = b.getScore() + "";
                    winner = b.getName();
                    playerList.add(i , winner);
                    scoreList.add(i , score);
                }
                openDarts4();
            }
            else{
                currentRound = session.round();
                if(rounds < currentRound)
                    currentRound--;
                textView1 = findViewById(R.id.Round);
                String x = "Round "+currentRound+" of "+rounds;
                textView1.setTextColor(Color.BLACK);
                textView1.setText(x);
                updatePlayerScore(ogIndex);
            }
        }
              void updatePlayerScore(int ogIndex){
              TextView currentTextView = scoreTextViewArray.get(ogIndex);
              int finalScore = session.getScorePlayer(ogIndex);
              String a = finalScore + "";
              currentTextView.setText(a);
              int newIndex = session.nextName();
              textView.setTextColor(Color.BLACK);
              textView.setText(String.valueOf(name.get(newIndex)));
              }
        });
        // prepare GameEngine initialization
        this.session = new GameEngine(number, rounds, name);
        createScoreBoard(session);
    }
        @SuppressLint("ResourceAsColor")
        void createScoreBoard(GameEngine session){
        //get names from  name arraylist of string type
        // for loop: run number times.
            //create textbox with name from name arraylist
            //create textbox with 0 score
            // store textbox with score info into an array and return the array in it.

        int k = 0;
        LinearLayout scoreBoard = (LinearLayout) findViewById(R.id.scoreBoard);

        for(int i = 0; i<2*number ; i++){
            TextView temp = new TextView(this);
            if(i%2 == 0) {
                temp.setId(i);
                temp.setTextColor(Color.BLACK);
                temp.setBackgroundResource(R.color.white);
                
                scoreBoard.addView(temp);
                temp.setTextSize(40);
                temp.setText(name.get(k).toString());
                k++;
            }
            else {
                temp.setId(i);
                temp.setTextSize(30);
                temp.setTextColor(Color.parseColor("#ffffff"));
                temp.setBackgroundColor(0xFF000000);
                temp.setText("0");
                scoreBoard.addView(temp);
                this.scoreTextViewArray.add(temp);
            }
        }
    }

    public void openDarts4(){
        Intent intent = new Intent(this , Darts4.class);
        intent.putStringArrayListExtra("ok",playerList);
        intent.putStringArrayListExtra("yay",scoreList);
        intent.putExtra(EXTRA_NUMBER1,number);
        startActivity(intent);
    }
}


