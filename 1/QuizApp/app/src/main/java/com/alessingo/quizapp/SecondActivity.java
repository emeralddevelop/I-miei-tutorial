package com.alessingo.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    
    private static final String KEY_point = SecondActivity.class.getCanonicalName()+".point";
    private static final String KEY_pointTotal = SecondActivity.class.getCanonicalName()+".pointTotal";
    private static final String TAG = SecondActivity.class.getCanonicalName();
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text = findViewById(R.id.text);

        int point = getIntent().getIntExtra(KEY_point, 0);
        int pointTotal = getIntent().getIntExtra(KEY_pointTotal, 0);

        text.setText("Il tuo punteggio è: "+String.valueOf(point)+"/"+String.valueOf(pointTotal));

    }

    public static Intent getInstanceIntent(Context context, int point, int pointTotal) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(KEY_point, point);
        intent.putExtra(KEY_pointTotal, pointTotal);
        return intent;
    }
}
