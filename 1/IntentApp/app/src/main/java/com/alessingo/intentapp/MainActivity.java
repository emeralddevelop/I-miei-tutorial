package com.alessingo.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.sip.SipErrorCode;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: button");
                startIntent();
                /*Intent intent = SecondActivity.getIstanceIntent(MainActivity.this, "intent_value");
                startActivity(intent);*/
            }
        });
    }

    private void startIntent() {
        //è stato settata una action come intent filter nel manifest
        Intent intent = new Intent();
        intent.setAction("com.alessingo.intentapp.startsecondactivity");
        startActivity(intent);
    }
}
