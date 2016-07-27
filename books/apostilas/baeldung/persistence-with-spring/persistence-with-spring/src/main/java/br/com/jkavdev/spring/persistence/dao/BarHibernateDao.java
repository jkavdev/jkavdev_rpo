package br.com.jkavdev.spring.persistence.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BarHibernateDao {

	@Autowired
	SessionFactory factory;

	protected Session getCurrentSession() {
		return factory.getCurrentSession();
	}

}
