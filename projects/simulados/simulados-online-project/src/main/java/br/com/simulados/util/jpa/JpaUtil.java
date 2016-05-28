package br.com.simulados.util.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("simuladosPU");

	public static EntityManager createEntityManager() {
		return factory.createEntityManager();
	}

}
