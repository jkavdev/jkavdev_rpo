package br.com.jkavdev.hibernate.utils.database.interfaces;

//responsavel por criacaos dos servicos

public interface IServiceFactory {

	//retornar uma instancia de um service de categoria
	ICategoryServices getCategoryServices();
	//retornar uma instancia de um service de produto
	IProductServices getProductServices();

}
