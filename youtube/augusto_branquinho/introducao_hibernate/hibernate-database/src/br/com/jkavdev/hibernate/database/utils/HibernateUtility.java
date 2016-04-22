package br.com.jkavdev.hibernate.database.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//classe responsavel por retornar a sessao do hibernate

public class HibernateUtility {

	private static SessionFactory sessionFactory;

	private static final ThreadLocal<Session> sessionThread;

	static {
		sessionThread = new ThreadLocal<>();
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static Session getSession() {
		Session session = sessionThread.get();
		if(session == null){
			session = sessionFactory.openSession();
			sessionThread.set(session);
		}
		return session;
	}

}
