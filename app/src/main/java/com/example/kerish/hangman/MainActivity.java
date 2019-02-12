package com.example.kerish.hangman;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    EditText gg;
    Button btn;
    TextView textView;
    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.word);
        gg = (EditText) findViewById(R.id.guess);
        btn = (Button) findViewById(R.id.button);
        animationView = (LottieAnimationView) findViewById(R.id.animation);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gg.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Enter your letter first !", Toast.LENGTH_SHORT).show();
                }
                else{
                    ReplaceMe();
                }
            }
        });
    }

    private void ReplaceMe()
    {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(gg.getWindowToken(), 0);

        Intent jerry = getIntent();
        String t_word = jerry.getStringExtra("secret_word").toLowerCase();

        int length = t_word.length();
        char[] word = new char[length];                         // word char

        for(int j=0;j<length;j++){
            word[j] = t_word.charAt(j);
        }

        int k = length;

        while(k!=0){

            String guess = gg.getText().toString().toLowerCase();

            String m_word = textView.getText().toString();
            char guess_letter = guess.charAt(0);

            char[] dash = new char[length];

            if(m_word.equals("")){
                for(int i=0;i<length;i++){
                    dash[i] = '-';
                    k--;
                }
            }
             else{
                for(int i=0;i<length;i++){
                    dash[i] = m_word.charAt(i);
                    k--;
                 }
            }

            for(int i=0;i<length;i++){
                if(guess_letter == word[i] && guess_letter!=dash[i]){
                    dash[i] = guess_letter;
                    animationView.setAnimation("emoji_wink.json");
                    animationView.loop(true);
                    animationView.playAnimation();
                }
                else if(guess_letter != word[i])
                {
                    animationView.setAnimation("angry_emoji.json");
                    animationView.loop(true);
                    animationView.playAnimation();
                    }
                }

                String string = "";
                for(int jj=0;jj<length;jj++){
                    string = string + dash[jj];
                }
                gg.setText(null);
                textView.setText(string);
            }
            if(t_word.equalsIgnoreCase(textView.getText().toString())){
            Intent intent = new Intent(MainActivity.this, Won.class);
            startActivity(intent);
            finish();
        }
        }
}
