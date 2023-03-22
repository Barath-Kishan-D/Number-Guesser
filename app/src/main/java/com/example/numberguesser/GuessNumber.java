package com.example.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class GuessNumber extends AppCompatActivity {

    Button guess1,guess2,guess3,btnreset1;
    int count=1,randval,number1,number2,number3;
    int[] arr;
    Random random=new Random();
    int temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_number);

        TextView dispans = findViewById(R.id.dispans);

        guess1=findViewById(R.id.guess1);
        guess2=findViewById(R.id.guess2);
        guess3=findViewById(R.id.guess3);
        btnreset1=findViewById(R.id.btnreset1);

        arr=getIntent().getIntArrayExtra("passingArr");
        randval=random.nextInt(3);
        temp=arr[randval];

        for(int i=0;i<arr.length;i++){
            Log.d("guessingpage",i+" "+arr[i]);
        }

        guess1.setText(Integer.toString(arr[0]));
        guess2.setText(Integer.toString(arr[1]));
        guess3.setText(Integer.toString(arr[2]));

        guess1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number1=arr[0];
                guess1.setBackgroundColor(Color.RED);
                if(number1==temp){
                    dispans.setText("congrats on "+count+" tries");
                    guess1.setBackgroundColor(Color.GREEN);
                }
                guess1.setEnabled(false);
                count++;
            }
        });

        guess2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number2=arr[1];
                guess2.setBackgroundColor(Color.RED);
                if(number2==temp){
                    dispans.setText("congrats on " +count+" tries");
                    guess2.setBackgroundColor(Color.GREEN);
                }
                guess2.setEnabled(false);
                count++;
            }
        });

        guess3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number3=arr[2];
                guess3.setBackgroundColor(Color.RED);
                if(number3==temp){
                    dispans.setText("congrats on "+count+" tries");
                    guess3.setBackgroundColor(Color.GREEN);
                }
                guess3.setEnabled(false);
                count++;
            }
        });

        btnreset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }

    public void reset(){
        Intent intent=new Intent(GuessNumber.this,MainActivity.class);
        startActivity(intent);
    }
}