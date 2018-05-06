package br.edu.estacio.expiprodgame.bean;

import java.io.Serializable;

public class Usuariobadgeid implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long usuario;
	private Long badge;

	
	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public Long getBadge() {
		return badge;
	}

	public void setBadge(Long badge) {
		this.badge = badge;
	}

	@Override
	public int hashCode() {
		return (int) (usuario + badge);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuariobadgeid) {
			Usuariobadgeid usuarioBadgeId = (Usuariobadgeid) obj;
			return usuarioBadgeId.usuario == usuario
					&& usuarioBadgeId.badge == badge;
		}
		return false;
	}


}
