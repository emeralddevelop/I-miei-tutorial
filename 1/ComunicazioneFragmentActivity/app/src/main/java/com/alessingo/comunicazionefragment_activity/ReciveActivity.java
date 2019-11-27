package com.alessingo.comunicazionefragment_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ReciveActivity extends AppCompatActivity {

    private static final String KEY_value = ReciveActivity.class.getCanonicalName()+".value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recive);

        TextView textView = findViewById(R.id.textView);
        textView.setText(getIntent().getStringExtra(KEY_value));
    }

    public static Intent getInstanceIntent(Context context, String name) {
        Intent intent = new Intent(context, ReciveActivity.class);
        intent.putExtra(KEY_value, name);

        return intent;
    }
}
