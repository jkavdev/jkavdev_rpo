package br.com.jkavdev.hibernate.database.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.jkavdev.hibernate.database.ServiceFactory;
import br.com.jkavdev.hibernate.utils.database.beans.CategoryBean;
import br.com.jkavdev.hibernate.utils.database.interfaces.IServiceFactory;

public class ServicesDatabaseTest {

	private static final Logger LOGGER = Logger.getLogger(ServicesDatabaseTest.class);
	private static IServiceFactory serviceFactory = new ServiceFactory();

	@Test
	public void testFindAll() {

		LOGGER.info("Finding all registers");

		List<CategoryBean> categories = serviceFactory.getCategoryServices().findAllCategories();

		for (CategoryBean categoryBean : categories) {
			LOGGER.info(categoryBean);
		}

	}
	
	public static void main(String[] args) {
		CategoryBean automovel = createCategories("Automovel", "Automoveis Terrestres");
		CategoryBean estofado = createCategories("Estofados", "Moveis Usados");
		CategoryBean domestico = createCategories("Dometicos", "Linha Domestica");
		CategoryBean eletronico = createCategories("Eletronico", "Eletronicos");

		serviceFactory.getCategoryServices().insert(automovel);
		serviceFactory.getCategoryServices().insert(estofado);
		serviceFactory.getCategoryServices().insert(domestico);
		serviceFactory.getCategoryServices().insert(eletronico);
	}

	@Test
	public void testInsertCategories() {
		CategoryBean automovel = createCategories("Automovel", "Automoveis Terrestres");
		CategoryBean estofado = createCategories("Estofados", "Moveis Usados");
		CategoryBean domestico = createCategories("Dometicos", "Linha Domestica");
		CategoryBean eletronico = createCategories("Eletronico", "Eletronicos");

		serviceFactory.getCategoryServices().insert(automovel);
		serviceFactory.getCategoryServices().insert(estofado);
		serviceFactory.getCategoryServices().insert(domestico);
		serviceFactory.getCategoryServices().insert(eletronico);
	}

	private static CategoryBean createCategories(String name, String descrption) {
		CategoryBean categoryEntity = new CategoryBean();
		categoryEntity.setName(name);
		categoryEntity.setDescription(descrption);
		return categoryEntity;
	}

}
