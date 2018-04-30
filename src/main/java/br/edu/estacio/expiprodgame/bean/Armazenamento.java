package br.edu.estacio.expiprodgame.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Armazenamento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome;
	private String descricao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produto_id")
	private Produto produto;
	//data_criacao
	//data_modificacao
	//data_retirada
	//data_reposicao
	
	public Armazenamento() {
		super();
	}
	public Armazenamento(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	@Override
	public String toString() {
		return "Armazenamento [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao + ",Produto[id="+ (produto != null? produto.getId() :-1)+ "],"
						+ " Cliente[id=" + (cliente != null? cliente.getId() :-1) + "],"
						+ " Forncedor[id=" + (fornecedor != null? fornecedor.getId() :-1) + "] ]";
	}
	
}
