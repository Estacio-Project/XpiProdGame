package br.edu.estacio.expiprodgame.controller;

import br.edu.estacio.expiprodgame.bean.Usuario;
import br.edu.estacio.expiprodgame.service.UsuarioService;

public class UsuarioController  {
	private UsuarioService usuarioService;
	
	public UsuarioController() {
		super();
		 usuarioService = new UsuarioService();
	}

	public void inserir(Usuario usuario){
		usuarioService.add(usuario);
	}
	
	public void alterar(Usuario usuario){
		usuarioService.upd(usuario);
	}
	
	public void excluir(Usuario usuario,int id){
		usuarioService.del(usuario, id);
	}
	
	public void listar(){
		usuarioService.all();
		usuarioService.getEmf().getTemp();
	}
	
}
