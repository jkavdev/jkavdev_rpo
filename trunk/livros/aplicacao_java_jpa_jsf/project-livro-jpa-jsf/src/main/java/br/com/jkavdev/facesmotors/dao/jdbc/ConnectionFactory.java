package br.com.jkavdev.facesmotors.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class ConnectionFactory {
	
	public ConnectionFactory() {
	}
	
	//JDBC
	public Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jpa_jsf_livro", "root", "99346554");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return connection;
	}
	
	private static final String PERSISTENCE_UNIT_NAME = "jpaMysqlPU";
	private static ThreadLocal<EntityManager> manager = new ThreadLocal<EntityManager>();
	private static EntityManagerFactory factory;

	public static boolean isEntityManagerOpen(){
		return ConnectionFactory.manager.get() != null && ConnectionFactory.manager.get().isOpen();
	}
	
	public static EntityManager getEntityManager() {
		if (ConnectionFactory.factory == null) {
			ConnectionFactory.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		EntityManager em = ConnectionFactory.manager.get();
		if (em == null || !em.isOpen()) {
			em = ConnectionFactory.factory.createEntityManager();
			ConnectionFactory.manager.set(em);
		}
		return em;
	}
	
	public static void evictCache(EntityManager em, String region){
		((Session)em.getDelegate()).getSessionFactory().getCache().evictQueryRegion(region);
	}

	public static void closeEntityManager() {
		EntityManager em = ConnectionFactory.manager.get();
		if (em != null) {
			EntityTransaction tx = em.getTransaction();
			if (tx.isActive()) { 
				tx.commit();
			}
			em.close();
			ConnectionFactory.manager.set(null);
		}
	}
	
	public static void closeEntityManagerFactory(){
		closeEntityManager();
		ConnectionFactory.factory.close();
	}

}
