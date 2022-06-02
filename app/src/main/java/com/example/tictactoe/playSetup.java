package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class playSetup extends AppCompatActivity {
    private EditText player1;
    private  EditText player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_setup);
        player1 = findViewById(R.id.player1Name);
        player2 = findViewById(R.id.player2Name);
        if(player1 == null){player1.setText("Player 01");}
        if(player2 == null){player2.setText("Player 02");}
    }
    public void submitButtonClick(View view){
        String player1Name = player1.getText().toString();
        String player2Name = player2.getText().toString();
        if (player1.length()==0) player1Name ="Player 01";
        if (player2.length()==0) player2Name ="Player 02";
        Intent intent = new Intent(this, gameDisplay.class);
        intent.putExtra("Player_Names", new String[] {player1Name,player2Name});
        startActivity(intent);
    }
}