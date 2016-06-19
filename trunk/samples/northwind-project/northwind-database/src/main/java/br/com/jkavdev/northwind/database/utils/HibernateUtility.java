package br.com.jkavdev.northwind.database.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

	private static SessionFactory factory;
	private static final ThreadLocal<Session> sessionThead;

	static {
		sessionThead = new ThreadLocal<>();
		factory = new Configuration().configure().buildSessionFactory();
	}

	public static Session getSession() {
		Session session = sessionThead.get();

		if (session == null) {
			session = factory.openSession();
			sessionThead.set(session);
		}

		return session;
	}

	public static void closeSession() {
		Session session = sessionThead.get();
		sessionThead.set(null);

		if (session != null && session.isOpen()) {
			session.flush();
			session.close();
		}
	}

}
