package br.com.jkavdev.spring.contacts.servlets;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.com.jkavdev.spring.contacts.repositories.AddressRepository;
import br.com.jkavdev.spring.contacts.repositories.ContactRepository;

@WebListener
public class Setup implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// instancia um AddressRepository
		// Init

		try {
			new AddressRepository().init();
			new ContactRepository().init();

			// Address address = new Address("150 West Tasman Dr.", "San Jose",
			// "CA", "95134");

			// addressRepository.create(address);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
