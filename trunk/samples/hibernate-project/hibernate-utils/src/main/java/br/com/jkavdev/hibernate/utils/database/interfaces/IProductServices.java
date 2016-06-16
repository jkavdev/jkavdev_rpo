package br.com.jkavdev.hibernate.utils.database.interfaces;

import java.util.List;

import br.com.jkavdev.hibernate.utils.database.beans.ProductBean;

//servicos para acesso dos produtos

public interface IProductServices {
	
	ProductBean findById(Long id);
	List<ProductBean> findAllProducts();
	Long insert(ProductBean product);
	void update(ProductBean product);
	void delete(ProductBean product);

}
