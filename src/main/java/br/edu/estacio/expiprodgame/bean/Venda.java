package br.edu.estacio.expiprodgame.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Venda implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome;
	
	private int desconto;
	private boolean promocao;
	private Date date_inicio_promocao;
	private Date date_final_promocao;
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
	
	

	public Venda() {
		super();
	}

	
	public Venda( String nome, int desconto,
			boolean promocao, Date date_inicio_promocao,
			Date date_final_promocao) {
		super();
	
		this.nome = nome;
		this.desconto = desconto;
		this.promocao = promocao;
		this.date_inicio_promocao = date_inicio_promocao;
		this.date_final_promocao = date_final_promocao;
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




	public int getDesconto() {
		return desconto;
	}




	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}






	public boolean isPromocao() {
		return promocao;
	}




	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}




	public Date getDate_inicio_promocao() {
		return date_inicio_promocao;
	}




	public void setDate_inicio_promocao(Date date_inicio_promocao) {
		this.date_inicio_promocao = date_inicio_promocao;
	}




	public Date getDate_final_promocao() {
		return date_final_promocao;
	}




	public void setDate_final_promocao(Date date_final_promocao) {
		this.date_final_promocao = date_final_promocao;
	}




	public Fornecedor getFornecedor() {
		return fornecedor;
	}




	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}




	public Produto getProduto() {
		return produto;
	}




	public void setProduto(Produto produto) {
		this.produto = produto;
	}




	public Cliente getCliente() {
		return cliente;
	}




	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}




	@Override
	public String toString() {
		return "Venda [id=" + id 
				+ ", promocao=" + promocao
				+ ", date_promocao=" + date_inicio_promocao
				+ ", data final promocao=" + date_final_promocao
				+ ", desconto=" + desconto + ", nome=" + nome + ","
				+ ",Produto[id="+ (produto != null? produto.getId() :-1)+ "],"
						+ " Cliente[id=" + (cliente != null? cliente.getId() :-1) + "],"
						+ " Forncedor[id=" + (fornecedor != null? fornecedor.getId() :-1) + "] ]";
	}
	
	
}
