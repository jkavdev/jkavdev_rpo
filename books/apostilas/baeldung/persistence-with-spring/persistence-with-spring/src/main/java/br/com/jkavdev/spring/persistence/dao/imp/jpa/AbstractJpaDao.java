package br.com.jkavdev.spring.persistence.dao.imp.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJpaDao<T extends Serializable> {

	private Class<T> entity;

	@PersistenceContext
	private EntityManager manager;

	public void setEntity(final Class<T> entity) {
		this.entity = entity;
	}

	public T findOne(final Long id) {
		return manager.find(entity, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return manager.createQuery("from " + entity.getName()).getResultList();
	}

	public void save(final T entity) {
		manager.persist(entity);
	}

	public T update(final T entity) {
		return manager.merge(entity);
	}

	public void delete(final T entity) {
		manager.remove(entity);
	}

	public void deleteById(final Long id) {
		final T entity = findOne(id);
		delete(entity);
	}

}
