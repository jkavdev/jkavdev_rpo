package br.com.jkavdev.northwind.database.utils;

import java.io.Serializable;
import java.util.List;

import br.com.jkavdev.northwind.utils.beans.BaseBeans;
import br.com.jkavdev.northwind.utils.database.interfaces.IServiceBase;

public abstract class GenericService <
	T extends BaseBeans,
	K extends BaseEntity,
	ID extends Serializable>
	extends GenericServiceWithKey<T, K, ID, ID>
	implements IServiceBase<T, ID> {

	@Override
	public T findById(ID id) {
		return parserEntity(getConcreteDao().findById(id));
	}

	@Override
	public List<T> findAll() {
		return parserEntity(getConcreteDao().findAll());
	}

	@Override
	public ID insert(T bean) {
		return getConcreteDao().save(parserBean(bean));
	}

	@Override
	public void update(T bean) {
		getConcreteDao().update(parserBean(bean));
	}

	@Override
	public void delete(T bean) {
		getConcreteDao().delete(parserBean(bean));
	}

}