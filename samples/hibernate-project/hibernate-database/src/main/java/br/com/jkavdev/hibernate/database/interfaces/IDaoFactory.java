package br.com.jkavdev.hibernate.database.interfaces;

public interface IDaoFactory {
	
	ICategoryDao getCategoryDao();
	IProductDao getProductDao();

}
