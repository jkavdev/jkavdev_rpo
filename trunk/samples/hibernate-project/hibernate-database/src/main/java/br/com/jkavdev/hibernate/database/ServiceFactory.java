package br.com.jkavdev.hibernate.database;

import br.com.jkavdev.hibernate.database.interfaces.IDaoFactory;
import br.com.jkavdev.hibernate.database.services.CategoryServices;
import br.com.jkavdev.hibernate.database.services.ProductServices;
import br.com.jkavdev.hibernate.database.utils.DaoFactory;
import br.com.jkavdev.hibernate.utils.database.interfaces.ICategoryServices;
import br.com.jkavdev.hibernate.utils.database.interfaces.IProductServices;
import br.com.jkavdev.hibernate.utils.database.interfaces.IServiceFactory;

//responsavel por criar as instancias de servicos

public class ServiceFactory implements IServiceFactory {

	//servicos
	private final ICategoryServices categoryService;
	private final IProductServices productService;
	
	//criando as instancias dos servicos
	public ServiceFactory() {
		IDaoFactory daoFactory = new DaoFactory();
		
		this.categoryService = new CategoryServices(daoFactory);
		this.productService = new ProductServices(daoFactory);
	}

	@Override
	public ICategoryServices getCategoryServices() {
		return this.categoryService;
	}

	@Override
	public IProductServices getProductServices() {
		return this.productService;
	}

}
