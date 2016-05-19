package br.com.jkavdev.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.jkavdev.hibernate.dto.UserOneToOne;
import br.com.jkavdev.hibernate.dto.Vehicle;

public class HibernateTestOneToOne {

	public static void main(String[] args) {

		UserOneToOne user = new UserOneToOne();
		user.setUserName("Jhonatan");

		UserOneToOne user1 = new UserOneToOne();
		user1.setUserName("Lucas");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Vectra");
		
		user.setVehicle(vehicle);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.save(user);
		session.save(user1);
		session.save(vehicle);

		session.getTransaction().commit();

	}

}
