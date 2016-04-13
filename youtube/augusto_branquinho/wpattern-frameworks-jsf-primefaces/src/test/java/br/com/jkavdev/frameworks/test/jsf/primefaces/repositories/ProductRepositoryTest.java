package br.com.jkavdev.frameworks.test.jsf.primefaces.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.jkavdev.frameworks.jsf.primefaces.model.ProductEntity;
import br.com.jkavdev.frameworks.jsf.primefaces.model.repositories.IProductRepository;
import br.com.jkavdev.frameworks.test.jsf.primefaces.AbstractDatabaseTest;

public class ProductRepositoryTest extends AbstractDatabaseTest {

	private static final Logger LOG = Logger.getLogger(ProductRepositoryTest.class);

	@Inject
	private IProductRepository productRepository;

	@Test
	public void testCategoryRepository() {
		List<ProductEntity> products = productRepository.findAll();
		LOG.info(products);
	}

}
