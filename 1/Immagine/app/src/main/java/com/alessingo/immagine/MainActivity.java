package com.alessingo.immagine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button button;
    ImageView imageView;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewByIds();
        imageView.setImageResource(R.drawable.homer_calcio);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: button");
                count++;
                switch (count) {
                    case 1:
                        imageView.setImageResource(R.drawable.homer_multa);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.homer_maiale);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.homer_calcio);
                        count = 0;
                        break;
                }
            }
        });
    }

    private void findViewByIds() {
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
    }
}
