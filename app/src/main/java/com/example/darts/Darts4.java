package com.example.darts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class Darts4 extends AppCompatActivity {

    TextView textView;
    TextView textView1;
    Button button;
    private ArrayList<String> playerList = new ArrayList<String>();
    private ArrayList<String> scoreList = new ArrayList<String>();
    private  int number;

    public static final String EXTRA_NUMBER1 = "com.example.application.example.EXTRA_NUMBER1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darts4);

        Intent intent = getIntent();
        textView1 = findViewById(R.id.display);
        textView = findViewById(R.id.winner);
        playerList = intent.getStringArrayListExtra("ok");
        scoreList = intent.getStringArrayListExtra("yay");
        number = intent.getIntExtra(Darts1.EXTRA_NUMBER1,0);
        textView.setText(playerList.get(0));
        textView1.setText(scoreList.get(0));

        button = (Button) findViewById(R.id.view);
        button.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                openDarts5();
            }
        });
    }

    public void openDarts5() {
        Intent intent = new Intent(this , Darts5.class);
        intent.putStringArrayListExtra("ok",playerList);
        intent.putStringArrayListExtra("yay",scoreList);
        intent.putExtra(EXTRA_NUMBER1,number);
        startActivity(intent);
    }
}