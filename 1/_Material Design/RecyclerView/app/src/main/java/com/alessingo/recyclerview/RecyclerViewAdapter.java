package com.alessingo.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<ModelData> utenti;

    public RecyclerViewAdapter(Context context, List<ModelData> utenti) {
        this.context = context;
        this.utenti = utenti;
    }


    //facciamo l'inflate (richiamaiamo il layout creato) e lo riportiamo sul ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.layout_row, parent, false);
        return new ViewHolder(view);
    }

    //Impostare l'oggetto preso dalla lista degli oggetti (ModelData)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ModelData utente = utenti.get(position);
        holder.textView.setText(utente.getName());
        holder.imageView.setImageResource(utente.getImage());
        holder.layoutRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Nome: "+utente.getName()+"\nID: "+utente.getImage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Restituisce la dimensione della lista
    @Override
    public int getItemCount() {
        return utenti.size();
    }


    //Definizione del ViewHolder (definisce i vari elelemnti del layout creato)
    public class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout layoutRow;
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            findViewByIds();
        }

        private void findViewByIds() {
            layoutRow = itemView.findViewById(R.id.layoutRow);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
