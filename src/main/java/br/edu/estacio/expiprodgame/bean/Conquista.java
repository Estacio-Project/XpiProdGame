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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Conquista implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome;
	private String descricao;
	@Temporal(TemporalType.DATE)
	private Date data_conquista;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
	public Conquista() {
		super();
	}
	public Conquista(String nome, String descricao, Usuario usuario, Date data_conquista) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.usuario = usuario;
		this.data_conquista = data_conquista;
	}
	public Conquista(String nome, String descricao) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.descricao = descricao;

		this.data_conquista =new Date();
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public Date getData_conquista() {
		return data_conquista;
	}
	public void setData_conquista(Date data_conquista) {
		this.data_conquista = data_conquista;
	}
	@Override
	public String toString() {
		return "Conquista [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao +  ", Usuario[id=" + (usuario != null? usuario.getId() :-1) + "] ]";
	}
	
	
	
	
}
