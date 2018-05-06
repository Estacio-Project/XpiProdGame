package br.edu.estacio.expiprodgame.bean;

import java.io.Serializable;
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
@IdClass(Usuariobadgeid.class)
@Table(name = "usuario_badge")
public class Usuariobadge {
	
	/**
	 * 
	 */

	@Id
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@Id
	@ManyToOne
	@JoinColumn(name="badge_id")
	private Badge badge;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data_recebimento;

	
	

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Badge getBadge() {
		return badge;
	}


	public void setBadge(Badge badge) {
		this.badge = badge;
	}


	public Date getData_recebimento() {
		return data_recebimento;
	}


	public void setData_recebimento(Date data_recebimento) {
		this.data_recebimento = data_recebimento;
	}



	
	
}
