package com.alessingo.tris;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();
    private Button buttons[] = new Button[9];
    private TextView text;
    private List<Integer> player1 = new ArrayList<>(), player2 = new ArrayList<>();
    private int onlinePlayer = 0, counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewByIds();

        onlinePlayer = new Random().nextInt(2)+1;
        if (onlinePlayer == 1) {
            text.setText("E' il turno di: Player 1");
        } else {
            text.setText("E' il turno di: Computer");
            computer();
        }
    }

    public void findViewByIds() {
        buttons[0] = findViewById(R.id.b1);
        buttons[1] = findViewById(R.id.b2);
        buttons[2] = findViewById(R.id.b3);
        buttons[3] = findViewById(R.id.b4);
        buttons[4] = findViewById(R.id.b5);
        buttons[5] = findViewById(R.id.b6);
        buttons[6] = findViewById(R.id.b7);
        buttons[7] = findViewById(R.id.b8);
        buttons[8] = findViewById(R.id.b9);
        text = findViewById(R.id.text);
    }

    public void clickOnButton(View view) {
        Button button = (Button) view;

        counter++;

        changeButton(button);
    }

    public void computer() {
        if (counter>=5)
            return;
        List<Integer> emptyCell = new ArrayList<>();
        int id, rIndex, cellId, delay;
        Button button;


        for (int i = 0; i < 9; i++) {
            id = buttons[i].getId();
            if (!(player1.contains(id) || player2.contains(id))) {
                emptyCell.add(id);
            }
        }

        rIndex = new Random().nextInt(emptyCell.size());
        cellId = emptyCell.get(rIndex);
        button = findViewById(cellId);
        changeButton(button);
    }

    private void changeButton(Button button) {
        button.setEnabled(false);
        if (onlinePlayer == 1) {
            button.setBackgroundColor(Color.RED);
            player1.add(button.getId());
            onlinePlayer = 2;
            text.setText("E' il turno di: Computer");
            computer();
        } else {
            button.setBackgroundColor(Color.BLUE);
            player2.add(button.getId());
            onlinePlayer = 1;
            text.setText("E' il turno di: Player 1");
        }

        if (checkWinner() == 1) {
            text.setText("Ha vinto: Player 1");
        }
        if (checkWinner() == 2) {
            text.setText("Ha vinto: Computer");
        }
    }

     private int checkWinner() {

         for (int i = 0; i < 9; i++) {
             if (i == 0 || i == 1 || i == 2) {      //colonne
                 if (player1.contains(buttons[i].getId()) && player1.contains(buttons[i+3].getId()) && player1.contains(buttons[i+6].getId())) return 1;
                 if (player2.contains(buttons[i].getId()) && player2.contains(buttons[i+3].getId()) && player2.contains(buttons[i+6].getId())) return 2;
             }
             if (i == 0 || i == 3 || i == 6) {      //righe
                if (player1.contains(buttons[i].getId()) && player1.contains(buttons[i+1].getId()) && player1.contains(buttons[i+2].getId())) return 1;
                if (player2.contains(buttons[i].getId()) && player2.contains(buttons[i+1].getId()) && player2.contains(buttons[i+2].getId())) return 2;
             }
         }
         //diagonale da in alto a sinistra ad in basso a destra
         if (player1.contains(buttons[0].getId()) && player1.contains(buttons[4].getId()) && player1.contains(buttons[8].getId())) return 1;
         if (player2.contains(buttons[0].getId()) && player2.contains(buttons[4].getId()) && player2.contains(buttons[8].getId())) return 2;

         //diagonale da in alto a destra ad in basso a sinistra
         if (player1.contains(buttons[2].getId()) && player1.contains(buttons[4].getId()) && player1.contains(buttons[6].getId())) return 1;
         if (player2.contains(buttons[2].getId()) && player2.contains(buttons[4].getId()) && player2.contains(buttons[6].getId())) return 2;

         return 0;
     }
}
