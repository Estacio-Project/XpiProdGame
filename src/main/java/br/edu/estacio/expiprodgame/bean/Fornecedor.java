package br.edu.estacio.expiprodgame.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Fornecedor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	private String nome;
	private String cnpj;
		//razao_social
		//endereco
		//telefone
		//email
		//data_cadastro
		//data_alteracao
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	



	
	public Fornecedor() {
		super();
	}



	public Fornecedor(String nome, String cnpj) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
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



	public String getCnpj() {
		return cnpj;
	}



	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	




	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj
				+ ", Usuario [" + (usuario != null ? usuario.getId():-1) + "] ]";
	}

	
	

}
