package com.alessingo.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private MyViewPager viewPagerAdapter;
    private CircleIndicator circleIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewPager);
        circleIndicator = findViewById(R.id.circleIndicator);

        setSupportActionBar(toolbar);

        viewPagerAdapter = new MyViewPager(this);
        viewPager.setAdapter(viewPagerAdapter);

        circleIndicator.setViewPager(viewPager);
    }
    //implementate le librerie:
    //          Glide ("pre carica" le immagini per evitare il lag dovuto al caricamento dell'immagine stessa)
    //          circleindicator (per inserire l'indicatore dell'immagine corrente su tutte le immagini)
}
