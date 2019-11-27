package com.alessingo.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtDomanda;
    private Button btnRisp1, btnRisp2, btnRisp3, btnRisp4, btnAvanti;
    private static int index = 0;
    private static int point = 0;
    Quiz quiz[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewByIds();

        quiz = new Quiz[]{
                new Quiz(getString(R.string.domanda_1), getString(R.string.risposta1_1), getString(R.string.risposta2_1), getString(R.string.risposta3_1), getString(R.string.risposta4_1), 4),
                new Quiz(getString(R.string.domanda_2), getString(R.string.risposta1_2), getString(R.string.risposta2_2), getString(R.string.risposta3_2), getString(R.string.risposta4_2), 3),
                new Quiz(getString(R.string.domanda_3), getString(R.string.risposta1_3), getString(R.string.risposta2_3), getString(R.string.risposta3_3), getString(R.string.risposta4_3), 2)
        };

        setText();
        setEnabled(true);

        btnAvanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if (index < quiz.length) {
                    setText();
                    setEnabled(true);
                    resetColorButton(btnRisp1, btnRisp2, btnRisp3, btnRisp4);
                } else {
                    startActivity(SecondActivity.getInstanceIntent(MainActivity.this, point, quiz.length));
                    finish();
                }
            }
        });
    }

    private void findViewByIds() {
        txtDomanda = findViewById(R.id.txtDomanda);
        btnRisp1 = findViewById(R.id.btnRisp1);
        btnRisp2 = findViewById(R.id.btnRisp2);
        btnRisp3 = findViewById(R.id.btnRisp3);
        btnRisp4 = findViewById(R.id.btnRisp4);
        btnAvanti = findViewById(R.id.btnAvanti);
    }

    public void clickBtnRisp(View view) {
        int id = view.getId();
        Button button = findViewById(id);
        int risp = 0;

        switch (id) {
            case R.id.btnRisp1:
                risp = 1;
                break;
            case R.id.btnRisp2:
                risp = 2;
                break;
            case R.id.btnRisp3:
                risp = 3;
                break;
            case R.id.btnRisp4:
                risp = 4;
                break;
        }

        setEnabled(false);

        if (quiz[index].isCorrectRisposta(risp)) {
            Toast.makeText(this, "Risposta esatta!", Toast.LENGTH_SHORT).show();
            button.setBackgroundColor(Color.GREEN);
            point++;
        } else {
            Toast.makeText(this, "Risposta errata!", Toast.LENGTH_SHORT).show();
            getButtonByNum(quiz[index].getRispostaVera()).setBackgroundColor(Color.GREEN);
            button.setBackgroundColor(Color.RED);
        }

    }

    private Button getButtonByNum(int num) {
        Button button = null;
        switch (num){
            case 1:
                button = findViewById(R.id.btnRisp1);
                break;
            case 2:
                button = findViewById(R.id.btnRisp2);
                break;
            case 3:
                button = findViewById(R.id.btnRisp3);
                break;
            case 4:
                button = findViewById(R.id.btnRisp4);
                break;
        }
        return button;
    }

    private void setEnabled(boolean enabled) {
        btnRisp1.setEnabled(enabled);
        btnRisp2.setEnabled(enabled);
        btnRisp3.setEnabled(enabled);
        btnRisp4.setEnabled(enabled);
        btnAvanti.setEnabled(!enabled);
    }

    private void setText() {
        txtDomanda.setText(quiz[index].getDomanda());
        btnRisp1.setText(quiz[index].getRisposta1());
        btnRisp2.setText(quiz[index].getRisposta2());
        btnRisp3.setText(quiz[index].getRisposta3());
        btnRisp4.setText(quiz[index].getRisposta4());
    }

    private void resetColorButton(Button... buttons) {
        for (int i=0; i<buttons.length; i++) {
            buttons[i].setBackgroundColor(Color.TRANSPARENT);
        }
    }
}
