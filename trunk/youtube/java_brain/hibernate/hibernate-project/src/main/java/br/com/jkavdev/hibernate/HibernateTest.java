package br.com.jkavdev.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.jkavdev.hibernate.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("Jhonatan");

		// processando as configuracoes do hibernate.cfg.xml e criando uma
		// sessionFactory
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		// criando uma sessao a partir da fabrica de sessoes
		Session session = sessionFactory.openSession();

		// abrindo uma sessao para transacoes no banco
		session.beginTransaction();

		// persistindo o objeto
		session.save(user);

		// commitando transacao
		session.getTransaction().commit();

	}

}
