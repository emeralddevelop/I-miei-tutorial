package com.alessingo.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    private RecyclerView recyclerView;
    private List<ModelData> utenti;
    private SwipeRefreshLayout swipe_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewByIds();

        utenti = new ArrayList<>();

        utenti.add(new ModelData("Bart", R.drawable.bart));
        utenti.add(new ModelData("Homer", R.drawable.homer));
        utenti.add(new ModelData("Lisa", R.drawable.lisa));
        utenti.add(new ModelData("Maggie", R.drawable.maggie));
        utenti.add(new ModelData("Nonno", R.drawable.nonno));
        utenti.add(new ModelData("Sindaco", R.drawable.sindaco));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);;
        recyclerView.setAdapter(new RecyclerViewAdapter(this, utenti));
        recyclerView.setHasFixedSize(true);     //le CardView sono tutte delle stesse dimesioni

        setUpSwipeRefresh();
    }

    private void findViewByIds() {
        recyclerView = findViewById(R.id.recyclerView);
        swipe_container = findViewById(R.id.swipe_container);
    }

    //imposta i parametri del swipe refresh
    private void setUpSwipeRefresh() {
        swipe_container.setOnRefreshListener(this);
        swipe_container.setColorScheme(
                android.R.color.holo_blue_light,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
    }

    //viene richiamato al momento dello swipe
    @Override
    public void onRefresh() {

    }
}
