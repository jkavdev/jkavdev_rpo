package org.wpattern.frameworks.test.hibernate4.daos;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.wpattern.frameworks.hibernate4.daos.ProductDAO;
import org.wpattern.frameworks.hibernate4.entites.ProductEntity;
import org.wpattern.frameworks.hibernate4.utils.DAOFactory;

public class ProductRepositoryTest {
	
//	private static final Logger LOGGER = Logger.getLogger(CategoryRepositoryTest.class);
//	private ProductDAO productDAO = DAOFactory.productInstance();
//
//	@Test
//	public void testFindAll() {
//		List<ProductEntity> products = this.productDAO.findAll();
//		
//		LOGGER.info(products);
//		System.out.println(products);
//	}
	
	public static void main(String[] args) {
		
		final Logger LOGGER = Logger.getLogger(CategoryRepositoryTest.class);
		ProductDAO productDAO = DAOFactory.productInstance();

			List<ProductEntity> products = productDAO.findAll();
			
			LOGGER.info(products);
			System.out.println(products);
		
	}

}
