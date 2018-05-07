package br.edu.estacio.expiprodgame.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@IdClass(Usuarioconquistaid.class)
@Table(name = "usuario_conquista")
public class Usuarioconquista {
	
	/**
	 * 
	 */

	@Id
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@Id
	@ManyToOne
	@JoinColumn(name="conquista_id")
	private Conquista conquista;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data_recebimento;

	
	

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	

	public Conquista getConquista() {
		return conquista;
	}


	public void setConquista(Conquista conquista) {
		this.conquista = conquista;
	}


	public Date getData_recebimento() {
		return data_recebimento;
	}


	public void setData_recebimento(Date data_recebimento) {
		this.data_recebimento = data_recebimento;
	}



	
	
}
