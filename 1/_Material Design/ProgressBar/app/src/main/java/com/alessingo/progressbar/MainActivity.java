package com.alessingo.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Handler handler;
    private Runnable runnable;
    private Timer timer;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);   //di default cirtcolare, con l'attributo style(nel XML) la si può avere orizzontale
        progressBar.setVisibility(View.VISIBLE);        //visible|invisible|gone(non è visibile, ma occupa lo spazio)
        //progressBar.setIndeterminate(true);             //infinita
        progressBar.setProgress(0);
        progressBar.setSecondaryProgress(0);
        progressBar.setMax(100);


        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (++i <= 100) {
                    progressBar.setProgress(i);
                    progressBar.setSecondaryProgress(i+10);
                } else {
                    timer.cancel();
                }
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 8000, 300);



    }
}
