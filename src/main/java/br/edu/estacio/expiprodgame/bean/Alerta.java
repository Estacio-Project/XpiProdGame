package br.edu.estacio.expiprodgame.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Alerta {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String descricao;

	@Temporal(TemporalType.DATE)
	private Date data_expiracao;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	/* @OneToOne(fetch = FetchType.LAZY) */
	/*
	 * @JoinColumns({
	 * 
	 * @JoinColumn(name = "armazenamento_id", insertable = false, updatable =
	 * false),
	 * 
	 * @JoinColumn(name = "produto_id", insertable = false, updatable = false)
	 * })
	 */
	public Alerta() {
		super();
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

	public Date getData_expiracao() {
		return data_expiracao;
	}

	public void setData_expiracao(Date data_expiracao) {
		this.data_expiracao = data_expiracao;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		Alerta other = (Alerta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String info() {
		return "Alerta [id=" + id + ", descricao=" + descricao
				+ ", data_expiracao=" + data_expiracao + ", Monitorconsumo[id="
				+ "], Usuario[id=" + (usuario != null ? usuario.getId() : -1)
				+ "]]";
	}

	@Override
	public String toString() {
		return getId().toString();
	}

}
