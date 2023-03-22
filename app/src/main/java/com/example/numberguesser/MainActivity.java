package com.example.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    void modifyArr(int index,int value){
        arr[index]=value;
    }

    void printArray(){
        for(int i:arr){
            System.out.println(i);
        }
    }

    int[] returnArr(){
        return arr;
    }

    boolean hashContains(int x){
        if(hm.containsKey(x)){
            return true;
        }
        return false;
    }

    void hashPut(int x){
        hm.put(x,1);
    }

    Button button;
    HashMap<Integer,Integer> hm=new HashMap<>();
    int[] arr=new int[3];
    Random random=new Random();
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.startbtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("helkisjd");
                startNewActivity();
            }
        });
    }

    public void startNewActivity(){

        MainActivity obj = new MainActivity();

        for(int i=0;i<3;i++){
            x = random.nextInt(20)+1;
            while(obj.hashContains(x)==true){
                x=random.nextInt(20)+1;
            }
            obj.hashPut(x);
            obj.modifyArr(i,x);
        }

        obj.printArray();

        Intent intent = new Intent(MainActivity.this,GuessNumber.class);
        intent.putExtra("passingArr",obj.returnArr());

        startActivity(intent);
    }

}