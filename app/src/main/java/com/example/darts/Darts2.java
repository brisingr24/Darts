package com.example.darts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

import static com.example.darts.Darts1.EXTRA_NUMBER1;
import static com.example.darts.Darts1.EXTRA_NUMBER2;

public class Darts2 extends AppCompatActivity {

    private Button button3;
    public static final String EXTRA_NUMBER1 = "com.example.application.example.EXTRA_NUMBER1";
    public static final String EXTRA_NUMBER2 = "com.example.application.example.EXTRA_NUMBER2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darts2);

        Intent intent = getIntent();
        int number = intent.getIntExtra(EXTRA_NUMBER1,0);
        int rounds = intent.getIntExtra(EXTRA_NUMBER2,0);

        ArrayList<EditText> store = new ArrayList<>();
        LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
        for(int i = 0 ; i<number ; i++){
        EditText temp = new EditText(this);
        temp.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25);
        temp.setId(i);
        temp.setSingleLine(true);
        linear.addView(temp);
            store.add(temp);
        }
        ArrayList<String> name = new ArrayList<>();

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for(int i = 0 ; i<number ; i++){
                    name.add(store.get(i).getText().toString());
                }
                Intent intent = new Intent(Darts2.this, Darts3.class);
                intent.putStringArrayListExtra("key", name);
                intent.putExtra(EXTRA_NUMBER1,number);
                intent.putExtra(EXTRA_NUMBER2,rounds);
                startActivity(intent);
            }
        });
    }
}