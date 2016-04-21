package br.com.jkavdev.hibernate.utils.database.interfaces;

import java.util.List;

import br.com.jkavdev.hibernate.utils.database.beans.ProductBean;

//reponsavel por retornar informacoes do produtos
//disponibiliza servicos

public interface IProductServices {
	
	//retorna um produto de acordo com um codigo
	ProductBean findById(Long id);
	//retorna todos os produtos
	List<ProductBean> findAllProducts();
	//insere um produto
	Long insert(ProductBean product);
	//atualiza produto
	void update(ProductBean product);
	//deleta produto
	void delete(ProductBean product);

}
