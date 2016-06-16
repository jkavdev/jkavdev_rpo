package br.com.jkavdev.hibernate.utils.database.interfaces;

//fabrica de servicos

public interface IServiceFactory {

	ICategoryServices getCategoryServices();
	IProductServices getProductServices();

}
