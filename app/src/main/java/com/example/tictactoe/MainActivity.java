package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tictac = findViewById(R.id.textView);
        String text="TicTacToe";
        SpannableString ss = new SpannableString(text);
        ForegroundColorSpan fred = new ForegroundColorSpan(Color.rgb(253,103,105));
        ForegroundColorSpan fyellow = new ForegroundColorSpan(Color.rgb(254,206,82));
        ForegroundColorSpan fbleu = new ForegroundColorSpan(Color.rgb(29,8,112));
        ss.setSpan(fbleu,0,3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(fyellow,3,6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(fred,6,9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tictac.setText(ss);
    }
    public void playButtonClick(View view){
        Intent intent = new Intent(this, playSetup.class);
        startActivity(intent);
    }

}