package org.wpttern.frameworks.hibernate4.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.wpttern.frameworks.hibernate4.daos.CategoryDAO;

public final class DAOFactory {

	public DAOFactory() {
	}

	private static final String PERSISTENCE_UNIT_NAME = "wprojectPersistenceUnit";
	private static EntityManagerFactory factory;
	private static CategoryDAO categoryDAO;

	public static EntityManagerFactory entityManagerFactoryInstance() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		return factory;
	}

	public static CategoryDAO categoryInstance() {
		if (categoryDAO == null) {
			categoryDAO = new CategoryDAO();
		}
		return categoryDAO;
	}

}
