package br.com.jkavdev.hibernate.database.daos;

import br.com.jkavdev.hibernate.database.entities.ProductEntity;
import br.com.jkavdev.hibernate.database.interfaces.IProductDao;
import br.com.jkavdev.hibernate.database.utils.GenericDao;

public class ProductDao extends GenericDao<ProductEntity, Long> implements IProductDao {

}
