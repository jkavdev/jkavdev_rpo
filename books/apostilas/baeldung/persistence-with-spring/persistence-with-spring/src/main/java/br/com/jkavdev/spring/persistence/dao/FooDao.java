package br.com.jkavdev.spring.persistence.dao;

import br.com.jkavdev.spring.persistence.dao.imp.hibernate.AbstractHibernateDao;
import br.com.jkavdev.spring.persistence.model.Foo;

public class FooDao extends AbstractHibernateDao<Foo> implements IFooDao {

	public FooDao() {
		setEntity(Foo.class);
	}

}
