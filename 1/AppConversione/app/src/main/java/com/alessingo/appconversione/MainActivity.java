package com.alessingo.appconversione;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button button;
    private TextView input, textEur, textUsd, textGbp;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findByIds();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: button");
                float inputV = Float.valueOf(input.getText().toString());
                String selezione = String.valueOf(spinner.getSelectedItem());
                switch (selezione) {
                    case "EUR":
                        Toast.makeText(MainActivity.this, "EUR", Toast.LENGTH_SHORT).show();
                        setOutput(inputV, inputV*1.11f, inputV*0.91f);
                        break;
                    case "USD":
                        Toast.makeText(MainActivity.this, "USD", Toast.LENGTH_SHORT).show();
                        setOutput(inputV*0.90f, inputV, inputV*0.82f);
                        break;
                    case "GBP":
                        Toast.makeText(MainActivity.this, "GBP", Toast.LENGTH_SHORT).show();
                        setOutput(inputV*1.09f, inputV*1.22f, inputV);
                        break;
                }
            }
        });

    }

    private void findByIds() {
        button = findViewById(R.id.button);
        input = findViewById(R.id.editText);
        textEur = findViewById(R.id.textViewEUR);
        textUsd = findViewById(R.id.textViewUSD);
        textGbp = findViewById(R.id.textViewGBP);
        spinner = findViewById(R.id.spinner);
    }

    private void setOutput(float eur, float usd, float gbp) {
        textEur.setText(String.valueOf(eur));
        textUsd.setText(String.valueOf(usd));
        textGbp.setText(String.valueOf(gbp));
    }
}
