package br.edu.estacio.expiprodgame.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome;
	private String cpf;
	//idade
	//endereco
	//telefone
	//email
	//data_cadastro
	//data_alteracao
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	
	public Cliente() {
		super();
	}



	public Cliente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	


	public Cliente(int id, String nome, String cpf, Usuario usuario) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.usuario = usuario;
	}


	public Cliente(int id, String nome, String cpf) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf
				 + "; Usuario [id=" + (usuario != null ? usuario.getId():-1)  +  "]]";
	}
	
	
	
	

	
	
}
