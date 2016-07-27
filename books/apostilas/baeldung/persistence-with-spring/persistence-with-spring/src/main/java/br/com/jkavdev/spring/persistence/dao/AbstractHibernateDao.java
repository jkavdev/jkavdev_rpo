package br.com.jkavdev.spring.persistence.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractHibernateDao<T extends Serializable> {

	private Class<T> entity;

	@Autowired
	private SessionFactory sessionFactory;

	public void setEntity(final Class<T> entity) {
		this.entity = entity;
	}

	public T findOne(final Long id) {
		return getCurrentSession().get(entity, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getCurrentSession().
				createQuery("from " + entity.getName()).list();
	}
	
	public void salve(final T entity){
		getCurrentSession().persist(entity);
	}
	
	public T update(final T entity){
		return (T) getCurrentSession().merge(entity);
	}
	
	public void delete(final T entity){
		getCurrentSession().delete(entity);
	}
	
	public void deleteById(final Long id){
		final T entity = findOne(id);
		delete(entity);
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
