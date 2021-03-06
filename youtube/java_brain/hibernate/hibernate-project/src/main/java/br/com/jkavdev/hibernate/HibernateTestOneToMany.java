package br.com.jkavdev.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.jkavdev.hibernate.dto.UserManyToMany;
import br.com.jkavdev.hibernate.dto.VehicleManyToMany;

public class HibernateTestOneToMany {

	public static void main(String[] args) {

		UserManyToMany user = new UserManyToMany();
		user.setUserName("Jhonatan");

		UserManyToMany user1 = new UserManyToMany();
		user1.setUserName("Lucas");

		VehicleManyToMany vehicle = new VehicleManyToMany();
		vehicle.setVehicleName("Vectra");

		VehicleManyToMany vehicle2 = new VehicleManyToMany();
		vehicle2.setVehicleName("Honda Sex");

		user.getVehicles().add(vehicle);
		user.getVehicles().add(vehicle2);
		user1.getVehicles().add(vehicle2);

		vehicle.getUsers().add(user);
		vehicle.getUsers().add(user1);
		vehicle2.getUsers().add(user1);

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
