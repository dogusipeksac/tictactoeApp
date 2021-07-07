package com.example.tictactoeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickButton(View view) {
        Button buttonSelected=(Button) view;
        int sellId=0;
        switch (buttonSelected.getId()){
            case R.id.button1:
                sellId=1;
                break;
            case R.id.button2:
                sellId=2;
                break;
            case R.id.button3:
                sellId=3;
                break;
            case R.id.button4:
                sellId=4;
                break;
            case R.id.button5:
                sellId=4;
                break;
            case R.id.button6:
                sellId=6;
                break;
            case R.id.button7:
                sellId=7;
                break;
            case R.id.button8:
                sellId=8;
                break;
            case R.id.button9:
                sellId=9;
                break;
        }
        PlayGame(sellId,buttonSelected);

    }
    int activePlayer=1;
    ArrayList<Integer> player1=new ArrayList<Integer>(); // player 1 data
    ArrayList<Integer> player2=new ArrayList<Integer>(); // player 2 data
    void PlayGame(int sellID,Button buttonSelected){

    if (activePlayer==1){
       // Toast.makeText(this,"Played player 1",Toast.LENGTH_SHORT).show();
        buttonSelected.setText("X");
        activePlayer=2;
        player1.add(sellID);
        buttonSelected.setBackgroundColor(Color.GREEN);
      //  Toast.makeText(this,"Turn player 2",Toast.LENGTH_SHORT).show();
        AutoPlay();


    }
    else if(activePlayer==2){
       // Toast.makeText(this,"Played player 2",Toast.LENGTH_SHORT).show();
        buttonSelected.setText("O");
        activePlayer=1;
        player2.add(sellID);
        buttonSelected.setBackgroundColor(Color.RED);
       // Toast.makeText(this,"Turn player 1",Toast.LENGTH_SHORT).show();
    }
    buttonSelected.setEnabled(false);
    CheckWinner();
    }
    void CheckWinner(){
        int winner=-1;
        //row 1
        if(player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
            winner=1;
        }
        if(player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            winner=2;
        }
        //row 2
        if(player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
            winner=1;
        }
        if(player2.contains(4)&&player2.contains(5)&&player2.contains(6)){
            winner=2;
        }
        //row 3
        if(player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
            winner=1;
        }
        if(player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            winner=2;
        }
        //colomn 1
        if(player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
            winner=1;
        }
        if(player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
            winner=2;
        }
        //colomn 2
        if(player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
            winner=1;
        }
        if(player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            winner=2;
        }
        //colomn 3
        if(player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
            winner=1;
        }
        if(player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
            winner=2;
        }
        if(winner!=-1){
            if(winner==1){
                Toast.makeText(this,"Player 1 is winner",Toast.LENGTH_LONG).show();
            }
            if(winner==2){
                Toast.makeText(this,"Player 2 is winner",Toast.LENGTH_LONG).show();
            }
        }

    }
    void AutoPlay(){
        int cellId;
        ArrayList<Integer> EmptyCells = new ArrayList<Integer>();   // all selected cells
    for(cellId=1;cellId<10;cellId++) {
        if (!(player1.contains(cellId) || player2.contains(cellId))) {
            EmptyCells.add(cellId);
        }
    }

        Random random=new Random();
        int randomIndex=random.nextInt(EmptyCells.size()-0)+0;
        int cellID=EmptyCells.get(randomIndex);
        Button buttonSelected;

        switch (cellID){
            case 1:
                buttonSelected=(Button) findViewById(R.id.button1);
                break;
            case 2:
                buttonSelected=(Button) findViewById(R.id.button2);
                break;
            case 3:
                buttonSelected=(Button) findViewById(R.id.button3);
                break;
            case 4:
                buttonSelected=(Button) findViewById(R.id.button4);
                break;
            case 5:
                buttonSelected=(Button) findViewById(R.id.button5);
                break;
            case 6:
                buttonSelected=(Button) findViewById(R.id.button6);
                break;
            case 7:
                buttonSelected=(Button) findViewById(R.id.button7);
                break;
            case 8:
                buttonSelected=(Button) findViewById(R.id.button8);
                break;
            case 9:
                buttonSelected=(Button) findViewById(R.id.button9);
                break;
            default:
                buttonSelected=(Button) findViewById(R.id.button1);
                break;
        }
        PlayGame(cellID,buttonSelected);




    }
}