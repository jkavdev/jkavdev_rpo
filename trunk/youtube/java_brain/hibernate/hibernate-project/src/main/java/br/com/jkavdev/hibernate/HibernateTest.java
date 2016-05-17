package br.com.jkavdev.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.jkavdev.hibernate.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserName("Jhonatan");
		user.setAddress("Qr 12 Casa 15");
		user.setJoinedDate(new Date());
		user.setDescription(
				"Normal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal User"
						+ "	Normal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal User");
		UserDetails user1 = new UserDetails();
		user1.setUserName("Lucas");
		user1.setAddress("Qr 12 Casa 15");
		user1.setJoinedDate(new Date());

		// processando as configuracoes do hibernate.cfg.xml e criando uma
		// sessionFactory
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		// criando uma sessao a partir da fabrica de sessoes
		Session session = sessionFactory.openSession();

		// abrindo uma sessao para transacoes no banco
		session.beginTransaction();

		// persistindo o objeto
		session.save(user);
		session.save(user1);

		// commitando transacao
		session.getTransaction().commit();
		session.close();

		user = null;

		session = sessionFactory.openSession();

		session.beginTransaction();
		user = session.get(UserDetails.class, 1);

		System.out.println("Nome do Usuario: " + user.getUserName());
		session.getTransaction().commit();

		session.close();
		sessionFactory.close();

	}

}
