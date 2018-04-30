package br.edu.estacio.expiprodgame.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Alerta implements Serializable {
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
	private Date data_expiracao;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "monitorconsumo_id")
	private MonitorConsumo monitorConsumo;

	public Alerta() {
		super();
	}

	public Alerta(String nome, String descricao, Date data_expiracao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.data_expiracao = data_expiracao;
	}

	public Alerta(int id, String nome, String descricao, Date data_expiracao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.data_expiracao = data_expiracao;
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

	public Date getData_expiracao() {
		return data_expiracao;
	}

	public void setData_expiracao(Date data_expiracao) {
		this.data_expiracao = data_expiracao;
	}

	@Override
	public String toString() {
		return "Alerta [id=" + id + ", descricao=" + descricao
				+ ", data_expiracao=" + data_expiracao + ", MonitorConsumo[id="
				+ (monitorConsumo != null ? monitorConsumo.getId() : -1)
				+ "], Usuario[id=" + (usuario != null ? usuario.getId() : -1)
				+ "]]";
	}

}
