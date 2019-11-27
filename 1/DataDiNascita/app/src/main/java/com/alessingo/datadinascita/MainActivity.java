package com.alessingo.datadinascita;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button calcola;
    private TextView input, output;
    private int annoN, annoA, eta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcola = findViewById(R.id.button);
        input = findViewById(R.id.editText);
        output = findViewById(R.id.textView);

        calcola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: calcola");
                annoN = Integer.valueOf(input.getText().toString());
                Calendar calendar = Calendar.getInstance();
                annoA = calendar.getWeekYear();
                eta = annoA - annoN;
                output.setText(String.valueOf(eta));
            }
        });
    }
}
