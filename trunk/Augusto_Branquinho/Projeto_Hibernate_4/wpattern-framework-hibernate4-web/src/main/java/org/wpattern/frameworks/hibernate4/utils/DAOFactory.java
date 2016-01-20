package org.wpattern.frameworks.hibernate4.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.wpattern.frameworks.hibernate4.daos.CategoryDAO;
import org.wpattern.frameworks.hibernate4.daos.OrderDAO;
import org.wpattern.frameworks.hibernate4.daos.OrderDetailDAO;
import org.wpattern.frameworks.hibernate4.daos.ProductDAO;

public final class DAOFactory {

	public DAOFactory() {
	}

	private static final String PERSISTENCE_UNIT_NAME = "wprojectPersistenceUnit";
	private static EntityManagerFactory factory;
	private static CategoryDAO categoryDAO;
	private static ProductDAO productDAO;
	private static OrderDAO orderDAO;
	private static OrderDetailDAO orderDetailDAO;

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

	public static ProductDAO productInstance() {
		if (productDAO == null) {
			productDAO = new ProductDAO();
		}
		return productDAO;
	}

	public static OrderDAO orderInstance() {
		if (orderDAO == null) {
			orderDAO = new OrderDAO();
		}
		return orderDAO;
	}

	public static OrderDetailDAO orderDetailInstance() {
		if (orderDetailDAO == null) {
			orderDetailDAO = new OrderDetailDAO();
		}
		return orderDetailDAO;
	}

}
