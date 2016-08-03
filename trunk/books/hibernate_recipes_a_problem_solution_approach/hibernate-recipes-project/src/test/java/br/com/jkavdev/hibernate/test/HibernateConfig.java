package br.com.jkavdev.hibernate.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

	public SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration();

		configuration.configure();

		return configuration.buildSessionFactory();
	}

}
