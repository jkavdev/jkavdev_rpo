package br.com.jkavdev.hibernate.database.interfaces;

//retornar os daos

public interface IDaoFactory {
	
	ICategoryDao getCategoryDao();
	IProductDao getProductDao();

}
