package br.edu.estacio.expiprodgame.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Venda  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;	
	private Long desconto;
	
	private boolean promocao;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_inicio_promocao;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
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

	
	public Venda( String nome, Long desconto,
			boolean promocao, Date date_inicio_promocao,
			Date date_final_promocao) {
		super();
	
		this.nome = nome;
		this.desconto = desconto;
		this.promocao = promocao;
		this.date_inicio_promocao = date_inicio_promocao;
		this.date_final_promocao = date_final_promocao;
	}











	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public void setDesconto(Long desconto) {
		this.desconto = desconto;
	}


	public Long getDesconto() {
		return desconto;
	}










	public boolean getPromocao() {
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
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String info(){
		return "Venda [id=" + id 
				+ ", nome= " + nome
				+ ", promocao= " + promocao
				+ ", date_promocao= " + date_inicio_promocao
				+ ", data final promocao= " + date_final_promocao
				+ ", desconto= " + desconto +  ","
				+ ",Produto[id= "+ (produto != null? produto.getId() :-1)+ "],"
						+ " Cliente[id= " + (cliente != null? cliente.getId() :-1) + "],"
						+ " Forncedor[id= " + (fornecedor != null? fornecedor.getId() :-1) + "] ]";
	}
	@Override
	public String toString() {
		return getId().toString();
	}
	
	
}
