package com.example.darts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Darts5 extends AppCompatActivity {

    private  int number;
    private ArrayList<String> playerList = new ArrayList<String>();
    private ArrayList<String> scoreList = new ArrayList<String>();

    public static final String EXTRA_NUMBER1 = "com.example.application.example.EXTRA_NUMBER1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darts5);

        Intent intent = getIntent();
        playerList = intent.getStringArrayListExtra("ok");
        scoreList = intent.getStringArrayListExtra("yay");
        number = intent.getIntExtra(Darts1.EXTRA_NUMBER1,0);

        TableLayout abc = (TableLayout) findViewById(R.id.table);

//        TableRow tBrow1 = new TableRow(this);
//        TextView t = new TextView(this);
//        t.setTextSize(30);
//        t.setText("SCOREBOARD");
//        t.setGravity(Gravity.CENTER_HORIZONTAL);
//        t.setTextColor(Color.BLACK);
//        tBrow1.addView(t);2
//        abc.addView(tBrow1);

        TableRow tbrow0 = new TableRow(this);
        TextView textView0 = new TextView(this);
        textView0.setText("NAME       ");
        textView0.setTextColor(Color.MAGENTA);
        textView0.setTextSize(40);
        tbrow0.addView(textView0);
        TextView textView1 = new TextView(this);
        textView1.setText("      SCORE");
        textView1.setTextSize(40);
        textView1.setTextColor(Color.MAGENTA);
        tbrow0.addView(textView1);
        abc.addView(tbrow0);

        for(int i = 0 ; i< number ; i++){
            TableRow tbrow = new TableRow(this);
            TextView temp = new TextView(this);
            temp.setText("  "+playerList.get(i)+"      ");
            temp.setTextSize(30);
            temp.setTextColor(Color.DKGRAY);
            temp.setGravity(Gravity.CENTER);
            tbrow.addView(temp);
            TextView temp2 = new TextView(this);
            temp2.setText("       "+scoreList.get(i));
            temp2.setTextSize(30);
            temp2.setTextColor(Color.DKGRAY);
            temp2.setGravity(Gravity.CENTER);
            tbrow.addView(temp2);
            abc.addView(tbrow);
        }
    }
}








