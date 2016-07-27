package br.com.jkavdev.spring.persistence.dao.imp.jpa;

import java.io.Serializable;

import br.com.jkavdev.spring.persistence.dao.IGenericDao;

public class GenericJpaDao<T extends Serializable>
	extends AbstractJpaDao<T>
	implements IGenericDao<T>{

}
