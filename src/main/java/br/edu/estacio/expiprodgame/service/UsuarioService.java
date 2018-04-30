package br.edu.estacio.expiprodgame.service;

import br.edu.estacio.expiprodgame.bean.Usuario;
import br.edu.estacio.expiprodgame.repository.EntityManagerFactoryThread;
import br.edu.estacio.expiprodgame.util.EntityName;
import br.edu.estacio.expiprodgame.util.Operacao;

public  class UsuarioService  {

	private EntityManagerFactoryThread emf;

	public void add(Usuario usuario) {
		// TODO Auto-generated method stub
		emf =  new EntityManagerFactoryThread(usuario,EntityName.USUARIO, Operacao.INSERIR.ordinal(),0);
		new Thread(emf).start();
	}
	
	public void upd(Usuario usuario) {
		// TODO Auto-generated method stub
		emf =  new EntityManagerFactoryThread(usuario,EntityName.USUARIO, Operacao.ALTERAR.ordinal(),0);
		new Thread(emf).start();
	}

	public void del(Usuario usuario,int id) {
		// TODO Auto-generated method stub
		emf =  new EntityManagerFactoryThread(usuario,EntityName.USUARIO, Operacao.EXCLUIR.ordinal(),id);
		new Thread(emf).start();
	}

	public void all() {
		// TODO Auto-generated method stub
		emf =  new EntityManagerFactoryThread(null,EntityName.USUARIO, Operacao.LISTAR.ordinal(),0);
		new Thread(emf).start();
	}

	public EntityManagerFactoryThread getEmf() {
		return emf;
	}
	
	

}
