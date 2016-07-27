package br.com.jkavdev.spring.persistence.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T extends Serializable> {

	T findOne(final Long id);

	List<T> findAll();

	void save(final T entity);

	T update(final T entity);

	void delete(final T entity);
	
	void deleteById(final Long entityId);

}
