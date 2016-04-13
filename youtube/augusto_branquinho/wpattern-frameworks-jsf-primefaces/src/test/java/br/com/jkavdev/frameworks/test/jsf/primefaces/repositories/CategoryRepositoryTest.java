package br.com.jkavdev.frameworks.test.jsf.primefaces.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.jkavdev.frameworks.jsf.primefaces.model.CategoryEntity;
import br.com.jkavdev.frameworks.jsf.primefaces.model.repositories.ICategoryRepository;
import br.com.jkavdev.frameworks.test.jsf.primefaces.AbstractDatabaseTest;

public class CategoryRepositoryTest extends AbstractDatabaseTest {

	private static final Logger LOG = Logger.getLogger(CategoryRepositoryTest.class);

	//injetara a classe sem uma implementacao, faz isso automaticamente
	@Inject
	private ICategoryRepository categoryRepository;

	@Test
	public void testCategoryRepository() {

		List<CategoryEntity> categories = categoryRepository.findAll();

		LOG.info(categories);

	}

}
