package br.com.jkavdev.hibernate.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager {

	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		try {
			return new Configuration().configure().buildSessionFactory();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}
