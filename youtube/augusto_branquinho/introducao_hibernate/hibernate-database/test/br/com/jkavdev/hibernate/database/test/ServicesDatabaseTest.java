package br.com.jkavdev.hibernate.database.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.jkavdev.hibernate.database.ServicesFactory;
import br.com.jkavdev.hibernate.utils.database.beans.CategoryBean;
import br.com.jkavdev.hibernate.utils.database.interfaces.IServiceFactory;

public class ServicesDatabaseTest {

	private static final Logger LOGGER = Logger.getLogger(ServicesDatabaseTest.class);

	private static IServiceFactory serviceFactory = new ServicesFactory();

	public void testInsert() {
		LOGGER.info("Testing method of insert");

		CategoryBean categoryBean = new CategoryBean();
		categoryBean.setDescription("Description 1");
		categoryBean.setName("Category 1");

		serviceFactory.getCategoryServices().insert(categoryBean);
	}

	@Test
	public void testFindAll() {

		LOGGER.info("Finding all registers");

		List<CategoryBean> categories = serviceFactory.getCategoryServices().findAllcategories();

		for (CategoryBean category : categories) {
			LOGGER.info(String.format("Category [%s]", category));
		}

	}
	
	public static void main(String[] args) {
		    
//		LOGGER.info("Testing method of insert");
//
//		CategoryBean categoryBean = new CategoryBean();
//		categoryBean.setDescription("Description 2");
//		categoryBean.setName("Category 2");
//
//		serviceFactory.getCategoryServices().insert(categoryBean);
		
		LOGGER.info("Finding all registers");

		List<CategoryBean> categories = serviceFactory.getCategoryServices().findAllcategories();

		for (CategoryBean category : categories) {
			LOGGER.info(String.format("Category [%s]", category));
		}
		
	}

}
