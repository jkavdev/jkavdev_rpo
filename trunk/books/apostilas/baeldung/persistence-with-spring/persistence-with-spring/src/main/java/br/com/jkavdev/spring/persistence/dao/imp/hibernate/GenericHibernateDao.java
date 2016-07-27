package br.com.jkavdev.spring.persistence.dao.imp.hibernate;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import br.com.jkavdev.spring.persistence.dao.IGenericDao;

@Repository
public class GenericHibernateDao<T extends Serializable> 
	extends AbstractHibernateDao<T> 
	implements IGenericDao<T> {

	

}
