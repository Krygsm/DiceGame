package com.example.dicegame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private int rollScore = 0;
    private int gameScore = 0;
    private int rollCount = 0;

    private Button rollButton;
    private Button resetButton;

    private TextView roll1;
    private TextView roll2;
    private TextView roll3;
    private TextView roll4;
    private TextView roll5;

    private TextView[] rolls = new TextView[5];
    private int[] diceRolls = new int[5];

    private TextView rollScoreView;
    private TextView gameScoreView;
    private TextView rollCountView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rollButton = findViewById(R.id.rollButton);
        resetButton = findViewById(R.id.resetButton);

        roll1 = findViewById(R.id.roll1);
        roll2 = findViewById(R.id.roll2);
        roll3 = findViewById(R.id.roll3);
        roll4 = findViewById(R.id.roll4);
        roll5 = findViewById(R.id.roll5);

        rolls[0]= roll1;
        rolls[1] = roll2;
        rolls[2] = roll3;
        rolls[3] = roll4;
        rolls[4] = roll5;

        rollScoreView = findViewById(R.id.rollScore);
        gameScoreView = findViewById(R.id.gameScore);
        rollCountView = findViewById(R.id.rollCount);


        rollButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                rollDice();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
    }

    void rollDice()
    {
        Random random = new Random();
        int sum = 0;

        for(int i = 0; i < diceRolls.length; i ++)
        {
            int roll = random.nextInt(6)+1;

            diceRolls[i] = roll;
            sum+=roll;
        }

        updateScore(sum);
        updateRollCount();
        displayDiceResults(diceRolls);
    }

    void resetGame()
    {
        for(int i = 0; i < rolls.length; i ++) rolls[i].setText(" ? ");

        rollScore = 0;
        gameScore = 0;
        rollCount = 0;

        rollScoreView.setText("Wynik tego losowania: 0");
        gameScoreView.setText("Wynik gry: 0");
        rollCountView.setText("Liczba rzutów: 0");
    }

    void updateScore(int newScore)
    {
        System.out.println(newScore);
        gameScore += newScore;
        rollScoreView.setText("Wynik tego losowania: " + String.valueOf(newScore));
        gameScoreView.setText("Wynik gry: " + String.valueOf(gameScore));
    }

    void updateRollCount()
    {
        rollCount++;
        rollCountView.setText("Liczba rzutów: " + String.valueOf(rollCount));
    }

    void displayDiceResults(int[] diceResults)
    {
        for(int i = 0; i < rolls.length; i++) rolls[i].setText(String.valueOf(diceResults[i]));
    }

}