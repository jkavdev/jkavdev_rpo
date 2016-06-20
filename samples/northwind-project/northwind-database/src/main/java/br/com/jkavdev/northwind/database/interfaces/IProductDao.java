package br.com.jkavdev.northwind.database.interfaces;

import br.com.jkavdev.northwind.database.entities.ProductEntity;
import br.com.jkavdev.northwind.database.utils.interfaces.IGenericDao;

public interface IProductDao extends IGenericDao<ProductEntity, Long> {

}
