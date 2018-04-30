package br.edu.estacio.expiprodgame.bean;

public class Pontuacao {

	private int id;
	private int pontos;
	private Usuario usuario;
	public Pontuacao(int pontos, Usuario usuario) {
		super();
		this.pontos = pontos;
		this.usuario = usuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Pontuacao [id=" + id + ", pontos=" + pontos + ", usuario="
				+ usuario.getLogin() + "]";
	}
	
	
}
