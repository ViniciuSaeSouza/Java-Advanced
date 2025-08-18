package com.example;

public class Jogo {
	protected Monte monte = new Monte();
	protected Jogador jogador = new Jogador();
	protected Computador computador = new Computador();

	public Jogo() {
		monte.embaralhar();
	}

	public Carta distribuirCartaParaJogador(Jogador jogador) {
		if (jogador.parou()) {
			return null;
		}
		var carta = monte.virar();
		jogador.receberCarta(carta);
		return carta;
	}

	public String resultado() {
		if (empatou()) {
			return "Empatou";
		}

		if (ganhou()) {
			return "Você ganhou!";
		}

		return "Você perdeu :(";
	}

	public boolean acabou() {
		// alguem estourou
		// ambos pararam
		// jogador parou
		return jogadorEstourou() || computadorEstourou() || osDoisPararam();
	}

	private boolean jogadorEstourou() {
		return jogador.getPontos() > 21;
	}
	private boolean computadorEstourou() {
		return computador.getPontos() > 21;
	}

	private boolean osDoisPararam() {
		return jogador.parou() && computador.parou();
	}

	private boolean osDoisEstouraram() {
		return jogadorEstourou() && computadorEstourou();
	}

	private boolean empatou(){
		return osDoisEstouraram() || jogador.getPontos() == computador.getPontos();
	}

	private boolean ganhou() {
		return computadorEstourou() || !jogadorEstourou() &&  jogador.getPontos() > computador.getPontos();
	}
}
