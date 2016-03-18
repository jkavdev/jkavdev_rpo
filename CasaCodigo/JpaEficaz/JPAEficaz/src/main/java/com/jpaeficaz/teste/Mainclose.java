package com.jpaeficaz.teste;

import javax.persistence.EntityManager;

import com.jpaeficaz.util.JpaUtil;

public class Mainclose {

	public static void main(String[] args) {

		//eh sempre importante entre a abertura e fechamento da transacao
		//verificar se algum erro acontece
		EntityManager manager = JpaUtil.getEntityManager();

		try {
			manager.getTransaction().begin();
			// faz algo
			manager.getTransaction().commit();
			
			//se ocorrer algum erro
		} catch (Exception e) {
			//se a transacao tiver aberta
			if (manager.isOpen()) {
				//faz um rollback
				manager.getTransaction().rollback();
			}
			
			//ao final de tudo 
		} finally {
			if(manager.isOpen()){
				//fecha o manager
				manager.close();
			}
		}

		System.out.println("Conectou");

	}

}
