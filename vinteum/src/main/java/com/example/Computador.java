package com.example;

public class Computador extends Jogador {

    // TODO -> você precisa fazer

    @Override // apenas uma indicação para o compilador java -> notação: Elas permitem
              // adicionar metadados ao código fonte, que podem ser utilizados pelo
              // compilador, ferramentas de desenvolvimento ou em tempo de execução.
    public boolean parou() {
        return this.getPontos() > 16; // vai retornar o resultado disso, ou T ou F
    } // ele vai ficar no get, pois o computador não vai ter um método parar

}
