package br.com.jkavdev.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.jkavdev.hibernate.dto.Address;
import br.com.jkavdev.hibernate.dto.UserDetails;

public class HibernateTest2 {
	
	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUserName("Jhonatan");
		user.setJoinedDate(new Date());
		user.setDescription(
				"Normal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal User"
						+ "	Normal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal UserNormal User");
		UserDetails user1 = new UserDetails();
		user1.setUserName("Lucas");
		user1.setJoinedDate(new Date());
		
		Address address = new Address();
		address.setCity("Planaltina");
		address.setPincode("73754012");
		address.setStreet("Qr 21 Casa 15");
		address.setState("Goiais");
		
		user.setAddress(address);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.save(user);
		session.save(user1);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
