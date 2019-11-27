package com.alessingo.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    
    Button btnAvanti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnAvanti = findViewById(R.id.btnAvanti);

        addFragment(new BlankFragment());

        btnAvanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(new Fragment());
            }
        });
    }

    private void addFragment(androidx.fragment.app.Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentAnchor, fragment);
        fragmentTransaction.addToBackStack(null);   //crea la coda, in modo che quando si prema indietro non si chiuda l'app ma visualizzi i precedenti fragment
        fragmentTransaction.commit();
    }
}

/*
 * Bisogna effettuare una transizione per ogni fragment, questo è un ottimo modo per usare un solo metodo e richiamarlo più volte per più fragment
 */