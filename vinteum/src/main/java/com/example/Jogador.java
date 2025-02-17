package com.example;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    // sempre que eu criar um jogador ele vai ter os valores padrões

    private int pontos = 0; // por padrão o int é 0
    private List<Carta> cartas = new ArrayList<>(); // quando o tipo é obj/referencia o valor padrão é null
    private boolean parou = false; // por padrão o valor é false

    public void receberCarta(Carta carta) {
        cartas.add(carta);
        pontos += carta.getNumero();
    }

    public void parar() {
        parou = true;
    }

    // ver os dados do jogador
    public int getPontos() {
        return pontos;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    // é is, pois é boolean, o prefixo passa a ser is, pois o bool é um estado
    public boolean parou() {
        return parou;
    }
}
