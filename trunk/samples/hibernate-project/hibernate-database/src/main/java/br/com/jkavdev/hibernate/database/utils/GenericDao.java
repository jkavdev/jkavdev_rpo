package br.com.jkavdev.hibernate.database.utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import br.com.jkavdev.hibernate.database.interfaces.IGenericDao;

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
		return getManager().find(getPersistentClass(), id);
	}

	@Override
	public List<T> findAll() {
		return findByCriteria();
	}

	@Override
	public ID save(T entity) {
		beginTransaction();
		getManager().persist(entity);
		commit();
		return null;
	}

	@Override
	public void update(T entity) {
		beginTransaction();
		getManager().merge(entity);
		commit();
	}

	@Override
	public void delete(T entity) {
		beginTransaction();
		getManager().remove(entity);
		commit();
	}

	public EntityManager getManager() {
		if (this.manager == null) {
			this.logger.error("EntityManager not Founded.");

			throw new IllegalStateException("EntitManager has not been set DAO before usage");
		}

		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	private Class<T> getPersistentClass() {
		return this.persistentClass;
	}

	@SuppressWarnings({ "unchecked" })
	private List<T> findByCriteria(Criterion... criterions) {
		Session session = (Session) getManager().getDelegate();
		Criteria createCriteria = session.createCriteria(getPersistentClass());

		for (Criterion criterion : criterions) {
			createCriteria.add(criterion);
		}

		return createCriteria.list();
	}

	private void commit() {
		getManager().getTransaction().commit();
	}

	private void beginTransaction() {
		getManager().getTransaction().begin();
	}

}
