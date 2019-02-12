package com.example.kerish.hangman;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Word extends AppCompatActivity {

    TextInputEditText textInputEditText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        textInputEditText = (TextInputEditText) findViewById(R.id.user_word);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NextActivity();
            }
        });
    }

    private void NextActivity() {

        String word = textInputEditText.getText().toString();

        if(word.equals("")){
            Toast.makeText(this, "Enter word First !", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(Word.this, MainActivity.class);
            intent.putExtra("secret_word", word);
            textInputEditText.setText(null);
            startActivity(intent);
        }

    }
}
