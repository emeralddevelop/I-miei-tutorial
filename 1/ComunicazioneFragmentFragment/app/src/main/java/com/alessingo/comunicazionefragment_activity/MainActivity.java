package com.alessingo.comunicazionefragment_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyListFragment.OnMyListListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentAnchor, new MyListFragment()).commit();
    }

    @Override
    public void onElementSelected(int pos) {
        Toast.makeText(this, "posizione: "+pos, Toast.LENGTH_SHORT).show();
    }
}
