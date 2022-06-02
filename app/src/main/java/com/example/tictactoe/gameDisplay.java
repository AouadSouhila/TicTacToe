package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gameDisplay extends AppCompatActivity {
    private ticTacToeBoard ticTacToeBoard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);
        Button playAgainBtn = findViewById(R.id.playAgain);
        Button homeBtn = findViewById(R.id.Home);
        TextView playerTurn = findViewById(R.id.player_display);
        String [] playerNames = getIntent().getStringArrayExtra("Player_Names");


        playAgainBtn.setVisibility(View.GONE);
        homeBtn.setVisibility(View.GONE);

        if(playerNames != null){
            playerTurn.setText((playerNames[0] + "'s Turn"));
        }

        ticTacToeBoard = findViewById(R.id.ticTacToeBoard);
        ticTacToeBoard.setUpGame(playAgainBtn,homeBtn,playerTurn,playerNames);
    }

    public void playAgainButton(View view){
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }
    public void homeClickButton(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}