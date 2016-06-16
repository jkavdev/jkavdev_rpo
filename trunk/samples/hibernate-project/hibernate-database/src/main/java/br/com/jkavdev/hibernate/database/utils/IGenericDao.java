package br.com.jkavdev.hibernate.database.utils;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T, ID extends Serializable> {

	T findById(ID id);
	List<T> findAll();
	ID save(T entity);
	void update(T entity);
	void delete(T entity);

}
