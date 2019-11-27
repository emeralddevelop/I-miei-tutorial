package com.alessingo.timerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SeekBar seekBar;
    private TextView textView;
    private Button button;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findByIds();

        seekBar.setMax(600);
        seekBar.setProgress(30);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimerText(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: button");
                seekBar.setEnabled(false);

                countDownTimer = new CountDownTimer(seekBar.getProgress()*1000+100, 1000) {
                    @Override
                    public void onTick(long l) {
                        updateTimerText((int) (l/1000));
                    }

                    @Override
                    public void onFinish() {
                        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.notification);
                        mediaPlayer.start();
                        resetTimer();
                    }
                };
                countDownTimer.start();
            }
        });
    }

    private void findByIds() {
        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
    }

    private void updateTimerText(int secondLeft) {
        int minute = secondLeft / 60;
        int seconds = secondLeft - minute * 60;

        String secondsString = String.valueOf(seconds);

        if (seconds < 10) {
            secondsString = "0" + secondsString;
        }

        textView.setText(String.valueOf(minute)+":"+secondsString);
    }

    private void resetTimer() {
        textView.setText("0:30");
        seekBar.setProgress(30);
        countDownTimer.cancel();
        seekBar.setEnabled(true);
    }
}
