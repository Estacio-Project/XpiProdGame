package br.edu.estacio.expiprodgame.util;

public enum TipoEstadoConsumo {

	 
	FORA_VALIDADE("Vencido"),
	DENTRO_VALIDADE("Consumivel"),
	LIMITE_VALIDADE("Limite Validade");
	
	private final String descricao;
	

	TipoEstadoConsumo(final String descricao) {

		this.descricao = descricao;
		
	}


	public String getDescricao() {
		return descricao;
	}	
	
	
	/*INDEFINIDO,
	CONSUMIDO,
	FABRICADO,
	DESCARTADO*/
	
	
}
