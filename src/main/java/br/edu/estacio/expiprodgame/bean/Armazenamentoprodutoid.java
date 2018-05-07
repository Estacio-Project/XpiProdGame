package br.edu.estacio.expiprodgame.bean;

import java.io.Serializable;

public class Armazenamentoprodutoid implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long armazenamento;
	private Long produto;

	public Long getArmazenamento() {
		return armazenamento;
	}

	public void setArmazenamento(Long armazenamento) {
		this.armazenamento = armazenamento;
	}

	public Long getProduto() {
		return produto;
	}

	public void setProduto(Long produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		return (int) (armazenamento + produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Armazenamentoprodutoid) {
			Armazenamentoprodutoid usuarioBadgeId = (Armazenamentoprodutoid) obj;
			return usuarioBadgeId.armazenamento == armazenamento
					&& usuarioBadgeId.produto == produto;
		}
		return false;
	}

}
