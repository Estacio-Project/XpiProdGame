package br.edu.estacio.expiprodgame.bean;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.edu.estacio.expiprodgame.util.TipoEstadoConsumo;


@Entity
@Table(name = "monitor_consumo")
public class Monitorconsumo{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String situacao;
	
	private int dias_restante;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produto_id")
	private Produto produto;

	
	
	public Monitorconsumo() {
		super();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	


	public int getDias_restante() {
		return dias_restante;
	}
	public void setDias_restante(int dias_restante) {
		this.dias_restante = dias_restante;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	public String getSituacao() {
		return situacao;
	}


	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monitorconsumo other = (Monitorconsumo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Monitorconsumo [id=" + id + ", status_produto="
				+ situacao + ", dias=" + dias_restante
				+ ", Produto [id=" + (produto!= null?produto.getId(): -1 ) + "] ]";
	}
	
	
	
	
}
