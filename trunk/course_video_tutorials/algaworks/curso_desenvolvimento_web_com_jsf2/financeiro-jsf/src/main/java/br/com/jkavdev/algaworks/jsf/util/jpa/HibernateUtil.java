package br.com.jkavdev.algaworks.jsf.util.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory SESSION_FACTORY;

	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure().buildSessionFactory();

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Session getSession() {
		return SESSION_FACTORY.openSession();
	}

}
