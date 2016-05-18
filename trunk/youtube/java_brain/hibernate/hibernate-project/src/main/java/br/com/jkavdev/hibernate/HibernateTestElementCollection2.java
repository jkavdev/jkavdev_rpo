package br.com.jkavdev.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.jkavdev.hibernate.dto.Address;
import br.com.jkavdev.hibernate.dto.UserDetails3;

public class HibernateTestElementCollection2 {

	public static void main(String[] args) {

		UserDetails3 user = new UserDetails3();
		user.setUserName("Jhonatan");
		user.setJoinedDate(new Date());
		user.setDescription(
				"Normal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal User"
						+ "	Normal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal User");
		UserDetails3 user1 = new UserDetails3();
		user1.setUserName("Lucas");
		user1.setJoinedDate(new Date());

		Address homeAddress = new Address();
		homeAddress.setCity("Planaltina Casa");
		homeAddress.setPincode("73754012");
		homeAddress.setStreet("Qr 21 Casa 15");
		homeAddress.setState("Goiais");

		Address officeAddress = new Address();
		officeAddress.setCity("Planaltina Trabalho");
		officeAddress.setPincode("73754012");
		officeAddress.setStreet("Qr 25 Casa 55");
		officeAddress.setState("Goiais");

		user.getListOfAddresses().add(homeAddress);
		user.getListOfAddresses().add(officeAddress);

		user1.getListOfAddresses().add(officeAddress);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.save(user);
		session.save(user1);

		session.getTransaction().commit();
		session.close();

	}

}
