package com.jpaeficaz.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaUtil {

	// nome do meu persistence unit
	private static final String PERSISTENCE_UNIT = "jpaMysqlPU";
	// thread que contera o entityManager
	private static ThreadLocal<EntityManager> threadManager = new ThreadLocal<>();
	// fabrica de managers
	private static EntityManagerFactory factory;

	public JpaUtil() {
	}

	//returnando o manager
	public static EntityManager getEntityManager() {
		//se a fabrica tiver nula, quer dizer que ainda nao foi criada
		if (factory == null) {
			//cria a fabrica
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		}
		
		//crio o manager a partir da thread		
		EntityManager manager = threadManager.get();
		
		//se o manager da thread nao estiver sido criado
		if (manager == null || !manager.isOpen()) {
			//cria o manager
			manager = factory.createEntityManager();
			//atribui o manager criado a thread
			JpaUtil.threadManager.set(manager);
		}
		return manager;
	}

	//fechando o manager
	public static void closeEntityManager() {
		//retorno o manager da thread
		EntityManager manager = threadManager.get();
		
		//se o manager nao estiver nulo, porque existe algum criado
		if (manager != null) {
			
			//retorno a transacao do manager
			EntityTransaction transaction = manager.getTransaction();
			//se a transacao tiver ativa
			
			if(transaction.isActive()){
				//faço o commit
				transaction.commit();
			}
		}
		//fecha o manager
		manager.close();
		//tira o manager do da thread
		threadManager.set(null);
	}
	
	//fechando a fabrica
	public static void closeEntityManagerFactory(){
		//fecha o manager e a fabrica
		closeEntityManager();
		factory.close();
	}

}
