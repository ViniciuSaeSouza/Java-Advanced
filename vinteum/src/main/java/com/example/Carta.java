package com.example;

public class Carta {
    private int numero;
    private Naipe naipe;

    public Carta(int numero, Naipe naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

    public String imagePath() {
        return "classic-cards/" + numero + naipe + ".png";
    }

    // para ler e ver qual o número e o naipe
    // pode ler, mas não pode escrever (set)
    public int getNumero() {
        return numero;
    }

    public Naipe getNaipe() {
        return naipe;
    }

}
