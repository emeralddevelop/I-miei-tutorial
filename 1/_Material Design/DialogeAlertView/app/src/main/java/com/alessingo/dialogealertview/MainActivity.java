package com.alessingo.dialogealertview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**Base**/
        /*builder = new AlertDialog.Builder(this);
        builder.setMessage("Caricamento in corso...");
        alertDialog = builder.create();
        alertDialog.show();*/
        /**************/


        /**Con due pulsanti**/
        /*builder = new AlertDialog.Builder(this);
        builder.setMessage("Eliminare il progetto?");
        builder.setPositiveButton("ELIMINA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "eliminato", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("ANNULLA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "annullato", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        alertDialog = builder.create();
        alertDialog.show();*/
        /**************/

        /**Custom con layout creato**/
        /*builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_layout, null);
        builder.setView(dialogView);
        final EditText editText = dialogView.findViewById(R.id.editText);
        builder.setMessage("Caricamento in corso...");
        builder.setPositiveButton("Conferma", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String s = editText.getText().toString().trim();
                Toast.makeText(MainActivity.this, "Il testo è: "+s, Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        alertDialog = builder.create();
        alertDialog.show();*/
        /**************/


        /**Custom per la conferma(senza layout)**/
        final String[] items = {"facile", "media", "difficile"};
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleziona la difficoltà");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Difficoltà selezionata: "+items[i], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("Conferma", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("ANNULLA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
        /**************/
    }
}
