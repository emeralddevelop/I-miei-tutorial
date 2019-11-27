package com.alessingo.textfield;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout username_textInput;
    private AppCompatEditText username_editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username_textInput = findViewById(R.id.username_textInput);
        username_editText = findViewById(R.id.username_editText);

        //restituisce true se è selezionata, false se non lo è (non solo alla pressione, ma a qualsiasi update che lo riguarda)
        username_editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (username_editText.getText().toString().trim().isEmpty()) {
                    username_textInput.setErrorEnabled(true);
                    username_textInput.setError("Bisogna inserire un username");
                } else {
                    username_textInput.setErrorEnabled(false);
                }
            }
        });
    }
}

/*
    aggiunta libreria per il design (com.android.support:design:28.0.0), massimo android 9 (sdk 28)
                                    (com.google.android.material:material:1.0.0), da android 10 (sdk 29)
 */