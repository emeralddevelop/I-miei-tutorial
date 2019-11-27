package com.alessingo.debug;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();
    private Button button = null;

    /*
    * Analyze --> Ispect Code (probabili errori e warning)
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String string = null;

        string = "ciao";
        string = "buongiorno";

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: button");
                Toast.makeText(MainActivity.this, "hai premuto il bottone", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
