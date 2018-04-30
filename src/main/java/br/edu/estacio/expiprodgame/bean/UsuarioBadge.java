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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="usuario_badge")
public class UsuarioBadge implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int  usuario_id;
	
	private int badge_id;
	
	public UsuarioBadge() {
		super();
	}
	
	
	
	public UsuarioBadge(int usuario_id, int badge_id) {
		super();
		this.usuario_id = usuario_id;
		this.badge_id = badge_id;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getUsuario_id() {
		return usuario_id;
	}



	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}



	public int getBadge_id() {
		return badge_id;
	}



	public void setBadge_id(int badge_id) {
		this.badge_id = badge_id;
	}



	@Override
	public String toString() {
		return "Alerta [id=" + id + 
				", usuario_id=" + usuario_id
				+ ", badge_id=" + badge_id
				+"]]";
	}

}
