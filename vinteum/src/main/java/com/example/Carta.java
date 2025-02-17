package com.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carta {
    private int numero;
    private Naipe naipe;

    public Carta(int numero, Naipe naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

    public String imagePath() {
        var numeroCarta = numero + "";
        List<String> nomesNaipe = Arrays.asList("Ace", "Jack", "King", "Queen");
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
        // TODO Auto-generated method stub
        return "Num: " + getNumero() + " || Naipe: " + getNaipe();
    }

}
