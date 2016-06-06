package br.com.jkavdev.spring.contacts.servlets;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.com.jkavdev.spring.contacts.entities.Address;
import br.com.jkavdev.spring.contacts.entities.Contact;
import br.com.jkavdev.spring.contacts.repositories.AddressRepository;
import br.com.jkavdev.spring.contacts.repositories.ContactRepository;

@WebListener
public class Setup implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		try {
			new AddressRepository().init();
			new AddressRepository().create(new Address("QR 12 CASA 15", "Planaltina", "GO", "73754012"));			
			new ContactRepository().init();
			new ContactRepository().create(new Contact("Jhonatan", 0L));
//			new ContactRepository().create(new Contact("Douglas", 0L));
//			new ContactRepository().create(new Contact("Lucas", 0L));
//			new ContactRepository().create(new Contact("Maria", 0L));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
