package com.example;

public class Carta {
    private int numero;
    private Naipe naipe;

    public Carta(int numero, Naipe naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

    public String imagePath() {
        var numeroCarta = numero + "";
        
        if (numero == 1) numeroCarta = "Ace";
        if (numero == 11) numeroCarta = "Jack";
        if (numero == 12) numeroCarta = "Queen";
        if (numero == 13) numeroCarta = "King";
        return "classic-cards/" + numeroCarta + naipe + ".png";
    }

    // para ler e ver qual o número e o naipe
    // pode ler, mas não pode escrever (set)
    public int getNumero() {
        return numero;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    @Override
    public String toString() {
        
        return "Num: " + getNumero() + " || Naipe: " + getNaipe();
    }

}
