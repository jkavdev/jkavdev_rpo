package br.com.jkavdev.hibernate.database.utils;

import org.hibernate.Session;

import br.com.jkavdev.hibernate.database.daos.CategoryDao;
import br.com.jkavdev.hibernate.database.daos.ProductDao;
import br.com.jkavdev.hibernate.database.interfaces.ICategoryDao;
import br.com.jkavdev.hibernate.database.interfaces.IDaoFactory;
import br.com.jkavdev.hibernate.database.interfaces.IProductDao;

//reponsavel por informar como instanciar um dao

public class DaoFactory implements IDaoFactory {

	private final ICategoryDao categoryDao;
	private final IProductDao productDao;

	public DaoFactory() {
		// atribuimos a variavel a instancia criada pelo metodo passando o dao
		// concreto
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

	// responsavel por criar uma instancia
	// recebe uma classe concreta do dao
	private GenericDao<?, ?> instantiateDao(Class<?> daoClass) {
		try {
			// instancia o dao
			GenericDao<?, ?> dao = (GenericDao<?, ?>) daoClass.newInstance();
			// associa a sessao atual ao dao
			dao.setSession(getCurrentSession());

			return dao;
		} catch (Exception e) {
			throw new RuntimeException(
					String.format("Cant instantiate DAO %s with the error %s.", daoClass, e.getMessage()), e);
		}
	}

	// retorna sessao atual atrelada ao dao
	private Session getCurrentSession() {
		return HibernateUtility.getSession();
	}

}
