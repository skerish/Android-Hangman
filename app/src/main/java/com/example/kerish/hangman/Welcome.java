package com.example.kerish.hangman;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textView = (TextView) findViewById(R.id.welcome);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                textView.setVisibility(View.VISIBLE);
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Welcome.this, Word.class);
                startActivity(intent);
                finish();
            }
        };

        Handler handler = new Handler();

        handler.postDelayed(runnable, 1000);
        handler.postDelayed(runnable2, 2500);
    }
}
