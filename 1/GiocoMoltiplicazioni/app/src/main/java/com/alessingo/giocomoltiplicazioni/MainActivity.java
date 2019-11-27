package com.alessingo.giocomoltiplicazioni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_ = MainActivity.class.getCanonicalName()+".key.timerPartita";
    private TextView textDomanda, textTimer, textRisultato;
    private Button button1, button2, button3, button4;
    private CountDownTimer countDownTimer;
    private long timerPartita = 30000L;
    private int ris = 0, punti = 0, puntiTot = 0, percentuale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewByIds();

        if (savedInstanceState != null) {
            timerPartita = savedInstanceState.getLong(KEY_);
        }

        countDownTimer = new CountDownTimer(timerPartita,1000L) {
            @Override
            public void onTick(long l) {
                timerPartita = timerPartita - 1000L;
                textTimer.setText("Rimangono: "+l/1000L+" secondi");
            }

            @Override
            public void onFinish() {
                try {
                    percentuale = (100 * punti) / puntiTot;
                } catch (ArithmeticException e) {
                    percentuale = 0;
                }
                textRisultato.setText("Hai fatto: "+punti+" punti su "+puntiTot+"\n hai fatto il: "+percentuale+"% di risposte giuste");
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                textTimer.setText("Hai finito il tempo a disposizione");
            }
        }.start();

        List<Integer> list = generaNumero();
        setTextButton(list);
    }

    private void findViewByIds() {
        textDomanda = findViewById(R.id.textDomanda);
        textTimer = findViewById(R.id.textTimer);
        textRisultato = findViewById(R.id.textRisultato);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
    }

    public void rispostaClick(View view) {
        int id = view.getId();
        Button button = null;

        switch (id) {
            case R.id.button1:
                button = button1;
                break;
            case R.id.button2:
                button = button2;
                break;
            case R.id.button3:
                button = button3;
                break;
            case R.id.button4:
                button = button4;
                break;
        }
        checkRisposta(button);
        List<Integer> list = generaNumero();
        setTextButton(list);
    }

    private List<Integer> generaNumero() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        int randNum1, randNum2;
        puntiTot++;

        for (int i=0; i<4; i++) {
            randNum1 = random.nextInt(11);
            randNum2 = random.nextInt(11);
            list.add(randNum1 * randNum2);

            if (i == 0) {
                textDomanda.setText("Qual'è il risultato di: "+randNum1+" x "+randNum2);
                ris = randNum1 * randNum2;
            }
        }
        //Mischia la lista
        Collections.shuffle(list);
        return list;
    }

    private boolean checkRisposta(Button button) {
        if (Integer.valueOf(button.getText().toString()) == ris) {
            punti++;
            return true;
        }
        return false;
    }

    private void setTextButton(List<Integer> list) {
        button1.setText(String.valueOf(list.get(0)));
        button2.setText(String.valueOf(list.get(1)));
        button3.setText(String.valueOf(list.get(2)));
        button4.setText(String.valueOf(list.get(3)));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(KEY_, timerPartita);
    }
}
