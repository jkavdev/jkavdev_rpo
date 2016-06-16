package br.com.jkavdev.hibernate.database.services;

import java.util.List;

import br.com.jkavdev.hibernate.database.interfaces.IDaoFactory;
import br.com.jkavdev.hibernate.database.interfaces.IProductDao;
import br.com.jkavdev.hibernate.utils.database.beans.ProductBean;
import br.com.jkavdev.hibernate.utils.database.interfaces.IProductServices;

public class ProductServices implements IProductServices {

	private final IProductDao productDao;

	public ProductServices(IDaoFactory daoFactory) {
		this.productDao = daoFactory.getProductDao();
	}

	@Override
	public ProductBean findById(Long id) {
		return null;
	}

	@Override
	public List<ProductBean> findAllProducts() {
		return null;
	}

	@Override
	public Long insert(ProductBean product) {
		return null;
	}

	@Override
	public void update(ProductBean product) {

	}

	@Override
	public void delete(ProductBean product) {

	}

}
