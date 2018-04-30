package br.edu.estacio.expiprodgame.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Badge implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome;
	private String descricao;
	@Temporal(TemporalType.DATE)
	private Date data;
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;*/
	
	@ManyToMany(mappedBy="badges")
	private List<Usuario> usuarios;
	
	public Badge() {
		super();
	}
	public Badge(String nome, String descricao, Usuario usuario, Date data) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
	}
	public Badge(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
		this.data = new Date();
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

	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	@Override
	public String toString() {
		return "Badge [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao + ", data="+ data +   ", Usuario[id=" + "]";
	}
	
	
}
