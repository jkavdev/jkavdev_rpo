package br.com.jkavdev.northwind.utils.database.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.jkavdev.northwind.utils.beans.BaseBeans;

public interface IServiceBase<T extends BaseBeans, ID extends Serializable> {

	ID insert(T bean);
	void update(T bean);
	void delete(T bean);
	T findById(ID id);
	List<T> findAll();

}
