package br.com.jkavdev.hibernate.database.utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

public abstract class GenericDao<T, ID extends Serializable> implements IGenericDao<T, ID> {

	private final Logger logger = Logger.getLogger(this.getClass());
	private final Class<T> persistentClass;
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public GenericDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public T findById(ID id) {
		return null;
	}

	@Override
	public List<T> findAll() {
		return null;
	}

	@Override
	public ID save(T entity) {
		return null;
	}

	@Override
	public void update(T entity) {

	}

	@Override
	public void delete(T entity) {
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		if (this.manager == null) {
			this.logger.error("EntityManager not Founded.");

			throw new IllegalStateException("EntitManager has not been set DAO before usage");
		}
		this.manager = manager;
	}

	private Class<T> getPersistentClass() {
		return this.persistentClass;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	private List<T> findByCriteria(Criterion... criterions) {
		Session session = (Session) getManager().getDelegate();
		Criteria createCriteria = session.createCriteria(getPersistentClass());

		for (Criterion criterion : criterions) {
			createCriteria.add(criterion);
		}

		return createCriteria.list();
	}

}
