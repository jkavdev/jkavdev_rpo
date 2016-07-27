package br.com.jkavdev.spring.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jkavdev.spring.persistence.dao.IGenericDao;
import br.com.jkavdev.spring.persistence.model.Foo;

@Service
public class FooService implements IFooService{
	
	IGenericDao<Foo> fooDao;
	
	@Autowired
	public void setFooDao(IGenericDao<Foo> fooDao) {
		this.fooDao = fooDao;
	}

}
