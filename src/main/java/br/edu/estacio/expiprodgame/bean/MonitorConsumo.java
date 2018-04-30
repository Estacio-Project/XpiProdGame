package br.edu.estacio.expiprodgame.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "monitor_consumo")
public class MonitorConsumo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String situacao;
	private int dias_restante;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produto_id")
	private Produto produto;

	
	
	public MonitorConsumo() {
		super();
	}
	public MonitorConsumo(int id, String situacao, int dias_restante,
			Produto produto) {
		super();
		this.id = id;
		this.situacao = situacao;
		this.dias_restante = dias_restante;
		this.produto = produto;
	}
	
	public MonitorConsumo(String situacao, int dias_restante) {
		super();
		this.situacao = situacao;
		this.dias_restante = dias_restante;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
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
	@Override
	public String toString() {
		return "MonitorConsumo [id=" + id + ", status_produto="
				+ situacao + ", dias=" + dias_restante
				+ ", Produto [id=" + (produto!= null?produto.getId(): -1 ) + "] ]";
	}
	
	
	
	
}
