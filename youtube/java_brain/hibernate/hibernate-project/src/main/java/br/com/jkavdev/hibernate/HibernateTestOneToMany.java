package br.com.jkavdev.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.jkavdev.hibernate.dto.UserOneToMany;
import br.com.jkavdev.hibernate.dto.Vehicle;

public class HibernateTestOneToMany {

	public static void main(String[] args) {

		UserOneToMany user = new UserOneToMany();
		user.setUserName("Jhonatan");

		UserOneToMany user1 = new UserOneToMany();
		user1.setUserName("Lucas");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Vectra");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Honda Sex");

		user.getVehicles().add(vehicle);
		user.getVehicles().add(vehicle2);
		user1.getVehicles().add(vehicle2);

		vehicle.setSer(user);
		vehicle.setSer(user1);
		vehicle2.setSer(user1);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.save(user);
		session.save(user1);
		session.save(vehicle);
		session.save(vehicle2);

		session.getTransaction().commit();

	}

}
