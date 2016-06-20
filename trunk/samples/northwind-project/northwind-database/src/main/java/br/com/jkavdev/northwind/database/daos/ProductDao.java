package br.com.jkavdev.northwind.database.daos;

import javax.inject.Named;

import br.com.jkavdev.northwind.database.entities.ProductEntity;
import br.com.jkavdev.northwind.database.interfaces.IProductDao;
import br.com.jkavdev.northwind.database.utils.GenericDao;

@Named
public class ProductDao extends GenericDao<ProductEntity, Long> implements IProductDao {

}
