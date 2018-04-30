package br.edu.estacio.expiprodgame.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.estacio.expiprodgame.util.Operacao;

public class EntityManagerFactoryThread implements Runnable {
	

	private  EntityManagerFactory entityManagerFactory ;
	private int option;
	private Object entity;
	private String classname;
	private  EntityManager tempEntityManager;
	private int finder;
	private List <Object>  temp = new ArrayList<Object>();
	public EntityManagerFactoryThread(Object o, String classname, int option, int find ) {
		super();
		this.option = option;
		this.entityManagerFactory = Persistence.createEntityManagerFactory("ExpProdGame");
		this.entity = o;
		this.classname = classname;
		this.tempEntityManager = this.entityManagerFactory.createEntityManager();
		this.finder =find;
	}



	public List<Object> getTemp() {
		return temp;
	}



	public void setTemp(List<Object> temp) {
		this.temp = temp;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		tempEntityManager.getTransaction().begin();
		System.out.println("---------------- " + classname +"----------------" );
		
		
		if (this.option == Operacao.INSERIR.ordinal()){
			System.out.println("---------------- " + Operacao.INSERIR.name()  + " ----------------" );
			System.out.println(entity.toString());
			tempEntityManager.persist(entity);

		}else if (this.option == Operacao.ALTERAR.ordinal()){
			System.out.println("---------------- " + Operacao.ALTERAR.name() +" ----------------" );
			System.out.println(entity.toString());
			
			tempEntityManager.merge(entity);
		}else if (this.option == Operacao.EXCLUIR.ordinal()){
			
			System.out.println("---------------- " + Operacao.EXCLUIR.name() +" ----------------" );
			System.out.println(entity.toString());
			
			Object tempFindEntity =    tempEntityManager.find(entity.getClass(), finder);
			tempEntityManager.remove(tempFindEntity);
			
			
		}else{
			
		/*	String hql = "SELECT E.id, E.login, E.senha FROM "+classname +" E";
			Query query =  (Query) tempEntityManager.createNamedQuery(hql);
			entityArray =  query.list();*/
			
			javax.persistence.Query query = tempEntityManager.createQuery ( " SELECT u FROM " + classname + " u " );
			 temp = ((List<Object>) query.getResultList());
			 
			 for (Object entity :temp) {
					System.out.println((entity).toString());

			 }
			
		}
		this.tempEntityManager.getTransaction().commit();
		this.tempEntityManager.close();
		this.entityManagerFactory.close();
	}
	
	

}
