package br.edu.estacio.expiprodgame.bean;

import java.io.Serializable;

public class Usuarioconquistaid implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long usuario;
	private Long conquista;

	
	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	

	public Long getConquista() {
		return conquista;
	}

	public void setConquista(Long conquista) {
		this.conquista = conquista;
	}

	@Override
	public int hashCode() {
		return (int) (usuario + conquista);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuarioconquistaid) {
			Usuarioconquistaid usuarioBadgeId = (Usuarioconquistaid) obj;
			return usuarioBadgeId.usuario == usuario
					&& usuarioBadgeId.conquista == conquista;
		}
		return false;
	}


}
