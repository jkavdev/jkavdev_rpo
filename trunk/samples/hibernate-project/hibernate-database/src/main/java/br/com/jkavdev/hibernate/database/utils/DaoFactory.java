package br.com.jkavdev.hibernate.database.utils;

import javax.persistence.EntityManager;

import br.com.jkavdev.hibernate.database.daos.CategoryDao;
import br.com.jkavdev.hibernate.database.daos.ProductDao;
import br.com.jkavdev.hibernate.database.interfaces.ICategoryDao;
import br.com.jkavdev.hibernate.database.interfaces.IDaoFactory;
import br.com.jkavdev.hibernate.database.interfaces.IProductDao;

public class DaoFactory implements IDaoFactory {

	private final ICategoryDao categoryDao;
	private final IProductDao productDao;

	public DaoFactory() {
		// informamos qual sera a classe concreta para instanciacao
		this.categoryDao = (ICategoryDao) instantiateDao(CategoryDao.class);
		this.productDao = (IProductDao) instantiateDao(ProductDao.class);
	}

	@Override
	public ICategoryDao getCategoryDao() {
		return this.categoryDao;
	}

	@Override
	public IProductDao getProductDao() {
		return this.productDao;
	}

	private GenericDao<?, ?> instantiateDao(Class<?> daoClass) {

		try {
			GenericDao<?, ?> dao = (GenericDao<?, ?>) daoClass.newInstance();

			dao.setManager(getCurrentEntityManager());

			return dao;
		} catch (Exception ex) {
			throw new RuntimeException(
					String.format("Can not instantiate DAO %s with the error %s.", daoClass, ex.getMessage()), ex);
		}

	}

	private EntityManager getCurrentEntityManager() {
		return JpaUtil.getEntityManager();
	}

}
