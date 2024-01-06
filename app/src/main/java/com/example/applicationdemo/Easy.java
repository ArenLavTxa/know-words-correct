package com.example.applicationdemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Easy extends ChooseTheStage {
    private String[] easy = {"a__ack", "c__rt", "scar__", "lig__", "_night"};
    private String[] easyans = {"tt", "ou", "ce", "ht", "k"};
    private int currentIndex = 0;
    private TextView word;
    private EditText userInput;
    public int score = 0;
    private int i = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_process);
        word = findViewById(R.id.word);
        userInput = findViewById(R.id.userInput);
        word.setText(easy[0]);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button nextButton = findViewById(R.id.accept);

        Button checkButton = findViewById(R.id.accept);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userTypedWord = userInput.getText().toString().toLowerCase();

                if (currentIndex >= easy.length - 1) {
                    Intent intent = new Intent(Easy.this, Score.class);
                    intent.putExtra("SCORE", score);
                    startActivity(intent);
                    finish();
                } else if (userTypedWord.equals(easyans[currentIndex])) {
                    currentIndex = (currentIndex + 1) % easy.length;
                    word.setText(easy[currentIndex]);
                    score++;
                    Toast.makeText(Easy.this, "Correct! Score: " + score, Toast.LENGTH_SHORT).show();
                    userInput.setText("");
                } else {
                    currentIndex = (currentIndex + 1) % easy.length;
                    word.setText(easy[currentIndex]);
                    Toast.makeText(Easy.this, "Incorrect!", Toast.LENGTH_SHORT).show();
                    userInput.setText("");
                }
                i++;
            }
        });
    }
}
