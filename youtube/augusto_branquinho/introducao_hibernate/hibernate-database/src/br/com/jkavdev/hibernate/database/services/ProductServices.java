package br.com.jkavdev.hibernate.database.services;

import java.util.List;

import br.com.jkavdev.hibernate.database.interfaces.IDaoFactory;
import br.com.jkavdev.hibernate.database.interfaces.IProductDao;
import br.com.jkavdev.hibernate.database.utils.ParserDatabase;
import br.com.jkavdev.hibernate.utils.database.beans.ProductBean;
import br.com.jkavdev.hibernate.utils.database.interfaces.IProductServices;

public class ProductServices implements IProductServices {

	// como pode haver varios daos usamos o fatory que podemos usar qualquer dao
	// usaremos apenas o dao que necessitamos
	private final IProductDao productDao;

	public ProductServices(IDaoFactory daoFactory) {
		this.productDao = daoFactory.getProductDao();
	}

	@Override
	public ProductBean findById(Long id) {
		return ParserDatabase.parserEntityToBean(this.productDao.findById(id));
	}

	@Override
	public List<ProductBean> findAllProducts() {
		return ParserDatabase.parseProductEntitiesToBeans(this.productDao.findAll());
	}

	@Override
	public Long insert(ProductBean product) {
		return this.productDao.save(ParserDatabase.parserBeanToEntity(product));
	}

	@Override
	public void update(ProductBean product) {
		this.productDao.update(ParserDatabase.parserBeanToEntity(product));
	}

	@Override
	public void delete(ProductBean product) {
		this.productDao.delete(ParserDatabase.parserBeanToEntity(product));
	}

}
