package br.com.jkavdev.northwind.database.utils.interfaces;

import java.util.List;

public interface IGenericDao<T, ID> {

	ID save(T entity);
	void update(T entity);
	void delete(T entity);
	T findById(ID id);
	List<T> findAll();

}
