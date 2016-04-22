package br.com.jkavdev.hibernate.database;

import br.com.jkavdev.hibernate.database.services.CategoryServices;
import br.com.jkavdev.hibernate.database.services.ProductServices;
import br.com.jkavdev.hibernate.utils.database.interfaces.ICategoryServices;
import br.com.jkavdev.hibernate.utils.database.interfaces.IProductServices;
import br.com.jkavdev.hibernate.utils.database.interfaces.IServiceFactory;

//factory que retorna os servicos do utils

public class ServicesFactory implements IServiceFactory {

	private final ICategoryServices categoryService;
	private final IProductServices productService;

	public ServicesFactory() {
		//instanciando os servicos com suas implementacoes do database
		this.categoryService = new CategoryServices();
		this.productService = new ProductServices();
	}

	//retornando servicos
	@Override
	public ICategoryServices getCategoryServices() {
		return this.categoryService;
	}

	@Override
	public IProductServices getProductServices() {
		return this.productService;
	}

}
