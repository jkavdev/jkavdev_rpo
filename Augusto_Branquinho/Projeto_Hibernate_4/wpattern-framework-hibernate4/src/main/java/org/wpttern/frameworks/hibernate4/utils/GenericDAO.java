package org.wpttern.frameworks.hibernate4.utils;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public abstract class GenericDAO<T, PK> {

	private final EntityManager manager;
	private final EntityManagerFactory factory;
	private Class<?> clazz;

	public GenericDAO() {
		this(DAOFactory.entityManagerFactoryInstance());
	}

	public GenericDAO(EntityManagerFactory factory) {
		super();
		this.factory = factory;
		this.manager = factory.createEntityManager();
		this.clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public Object executeQuery(String query, Object... params) {
		Query createQuery = this.manager.createQuery(query);
		for (int i = 0; i < params.length; i++) {

		}
		return createQuery;
	}

	public void delete(T entity){
		try{
			this.beginTransaction();
			this.manager.remove(entity);
			this.commit();
		}catch(Exception e){
			this.rollback();
			throw e;
		}
	}

	public void beginTransaction() {
		this.manager.getTransaction().begin();
	}

	public void commit() {
		this.manager.getTransaction().commit();
	}

	public void rollback() {
		this.manager.getTransaction().rollback();
	}

	public void close() {
		this.manager.close();
		this.factory.close();
	}

	public EntityManager geEntityManager() {
		return this.manager;
	}

}
