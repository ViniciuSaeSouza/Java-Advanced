package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monte {
    // Criamos uma lista vazia para evitar erros de `NullPointerException`. Essa variável representa uma caixa de cartas vazia
    private List<Carta> cartas = new ArrayList<>();

    public Monte() {

        for (Naipe naipe : Naipe.values()) {
            for (int numero = 1; numero <= 13; numero++) {
                cartas.add(new Carta(numero, naipe));
            }    
        }
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public Carta virar() {
        return cartas.remove(0);        
    }

}
