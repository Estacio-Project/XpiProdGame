package br.edu.estacio.expiprodgame.bean;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Produto  {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String descricao;
	private Float valor;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data_fabricacao;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data_vencimento;
	private int quantidade;
	
	
	
	public Produto() {
		super();
	}
	public Produto(String nome, String descricao, Float valor,
			Date data_fabricacao, Date data_vencimento, int quantidade) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.data_fabricacao = data_fabricacao;
		this.data_vencimento = data_vencimento;
		this.quantidade = quantidade;
	}
	public Produto(long id,String nome, String descricao, Float valor,
			Date data_fabricacao, Date data_vencimento, int quantidade) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.data_fabricacao = data_fabricacao;
		this.data_vencimento = data_vencimento;
		this.quantidade = quantidade;
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public Date getData_fabricacao() {
		return data_fabricacao;
	}
	public void setData_fabricacao(Date data_fabricacao) {
		this.data_fabricacao = data_fabricacao;
	}
	public Date getData_vencimento() {
		return data_vencimento;
	}
	public void setData_vencimento(Date data_vencimento) {
		this.data_vencimento = data_vencimento;
	}
	
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
	/*	return "Produto [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao + ", valor=" + valor + ", data_fabricacao="
				+ data_fabricacao + ", data_vencimento=" + data_vencimento
				+", quantidade"
				+ quantidade + "]";*/
		return ""+id + "";
	}
	
	
}
