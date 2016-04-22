package br.com.jkavdev.hibernate.database.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//classe responsavel por retornar a sessao do hibernate

@SuppressWarnings("deprecation")
public class HibernateUtility {

	private static SessionFactory sessionFactory;

	private static final ThreadLocal<Session> sessionThread;

	static {
		sessionThread = new ThreadLocal<>();
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public static Session getSession() {
		// uso a sessao da thread
		Session session = sessionThread.get();

		// se nao existir sessao
		if (session == null) {
			// crio uma
			session = sessionFactory.openSession();
			// atribuo a thread da sessao
			sessionThread.set(session);
		}
		return session;
	}

	public static void closeSession() {
		Session session = sessionThread.get();

		sessionThread.set(null);

		// verifico se ha alguma operacao aberta com a sessao
		if (session != null && session.isOpen()) {
			session.flush();
			session.close();
		}
	}

}
