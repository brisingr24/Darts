package com.example.darts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Darts1 extends AppCompatActivity {

    public static final String EXTRA_NUMBER1 = "com.example.application.example.EXTRA_NUMBER1";
    public static final String EXTRA_NUMBER2 = "com.example.application.example.EXTRA_NUMBER2";


    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darts1);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                openDarts2();
            }
        });
    }
    public void openDarts2(){
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        int number = Integer.parseInt(editText1.getText().toString());

        EditText editText2 = (EditText) findViewById(R.id.editText2);
        int rounds = Integer.parseInt(editText2.getText().toString());


        Intent intent = new Intent(this , Darts2.class);
        intent.putExtra(EXTRA_NUMBER1,number);
        intent.putExtra(EXTRA_NUMBER2,rounds);
        startActivity(intent);
    }
}
