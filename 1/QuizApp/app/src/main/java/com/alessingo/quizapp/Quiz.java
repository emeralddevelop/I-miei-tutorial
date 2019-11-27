package com.alessingo.quizapp;

public class Quiz {

    private String domanda;
    private String risposta1;
    private String risposta2;
    private String risposta3;
    private String risposta4;
    private int rispostaVera;

    public Quiz(String domanda, String risposta1, String risposta2, String risposta3, String risposta4, int rispostaVera) {
        this.domanda = domanda;
        this.risposta1 = risposta1;
        this.risposta2 = risposta2;
        this.risposta3 = risposta3;
        this.risposta4 = risposta4;
        if (rispostaVera > 0 && rispostaVera < 5) {
            this.rispostaVera = rispostaVera;
        } else {
            System.out.println("il valore non è compreso tra 0 e 5");
        }
    }

    public boolean isCorrectRisposta(int risposta) {
        if (risposta == rispostaVera) return true;
        return false;
    }

    public String getDomanda() {
        return domanda;
    }

    public String getRisposta1() {
        return risposta1;
    }

    public String getRisposta2() {
        return risposta2;
    }

    public String getRisposta3() {
        return risposta3;
    }

    public String getRisposta4() {
        return risposta4;
    }

    public int getRispostaVera() {
        return rispostaVera;
    }
}
