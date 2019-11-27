package com.alessingo.splashapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
        1) creata nuova immagine spalsh.xml, basata su un png inserito in drawble (android.png)
        2) creato nuovo tema in style.xml
        3) nel manifest impostato il tema ad SplashActivity e settata come activity iniziale
        4) in SplashActivity.java settato un delay e poi l'apertura di MainActivity
     */
}
