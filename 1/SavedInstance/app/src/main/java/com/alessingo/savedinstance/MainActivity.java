package com.alessingo.savedinstance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_ = "KEY";
    private TextView textView;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);

        if (savedInstanceState == null) {
            i = 0;
        } else {
            i = savedInstanceState.getInt(KEY_);
        }

        new Thread(new Run()).start();
    }

    private class Run implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //per poter effettuare modifiche grafiche
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        i++;
                        textView.setText(String.valueOf(i));
                    }
                });
            }
        }
    }

    //per salvare l'istanza
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_, i);
    }
}
