package org.wpattern.frameworks.test.hibernate4.daos;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.wpattern.frameworks.hibernate4.daos.CategoryDAO;
import org.wpattern.frameworks.hibernate4.entites.CategoryEntity;
import org.wpattern.frameworks.hibernate4.utils.DAOFactory;

public class CategoryRepositoryTest {

//	private static final Logger LOGGER = Logger.getLogger(CategoryRepositoryTest.class);
//	private CategoryDAO categoryDAO = DAOFactory.categoryInstance();

//	@Test
//	public void testFindAll() {
//		List<CategoryEntity> categories = this.categoryDAO.findAll();
//
//		LOGGER.info(categories);
//		System.out.println(categories);
//	}

	public static void main(String[] args) {
		
		final Logger LOGGER = Logger.getLogger(CategoryRepositoryTest.class);
		CategoryDAO categoryDAO = DAOFactory.categoryInstance();

		List<CategoryEntity> categories = categoryDAO.findAll();

		LOGGER.info(categories);
		System.out.println(categories);

	}

}
