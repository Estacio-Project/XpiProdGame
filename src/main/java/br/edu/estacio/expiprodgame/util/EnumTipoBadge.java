package br.edu.estacio.expiprodgame.util;

public enum EnumTipoBadge {
	INICIANTE("Gafanhoto", 250), INTERMEDIARIO("Panda", 500), ESPECIALISTA(
			"Tartagura", 750), EXPERT("Camundongo", 1000);
	private final String apelido;
	private final int pontos;

	EnumTipoBadge(final String nome, final int pontos) {

		this.apelido = nome;
		this.pontos = pontos;
	}

	public String toString() {
		return apelido;
	}

	public int getPontos() {
		return pontos;
	}

}
