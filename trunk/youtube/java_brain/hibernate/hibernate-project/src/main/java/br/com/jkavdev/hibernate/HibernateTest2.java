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
		
		Address homeAddress = new Address();
		homeAddress.setCity("Planaltina");
		homeAddress.setPincode("73754012");
		homeAddress.setStreet("Qr 21 Casa 15");
		homeAddress.setState("Goiais");
		
		Address officeAddress = new Address();
		officeAddress.setCity("Planaltina");
		officeAddress.setPincode("73754012");
		officeAddress.setStreet("Qr 25 Casa 55");
		officeAddress.setState("Goiais");
		
		user.setHomeAddress(homeAddress);
		user.setOfficeAddress(officeAddress);
		

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.save(user);
		session.save(user1);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
