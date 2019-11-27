package com.alessingo.lucchetto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewByIds();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: button");
                String input = editText.getText().toString().trim();
                if (input.equals("1234") && !input.isEmpty()) {
                    Intent intent = SecondActivity.getIstanceIntent(MainActivity.this);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Password non corretta", Toast.LENGTH_SHORT).show();
                }
                editText.setText("");
            }
        });
    }

    private void findViewByIds(){
        editText = findViewById(R.id.textView);
        button = findViewById(R.id.button);
    }
}
