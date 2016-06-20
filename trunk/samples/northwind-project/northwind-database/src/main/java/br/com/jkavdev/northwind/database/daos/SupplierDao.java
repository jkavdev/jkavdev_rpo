package br.com.jkavdev.northwind.database.daos;

import java.util.List;

import javax.inject.Named;

import br.com.jkavdev.northwind.database.entities.SupplierEntity;
import br.com.jkavdev.northwind.database.interfaces.ISupplierDao;
import br.com.jkavdev.northwind.database.utils.GenericDao;

@Named
public class SupplierDao extends GenericDao<SupplierEntity, Long> implements ISupplierDao {

	@Override
	public List<SupplierEntity> findSuppliersByProductName(String productName) {
		return executeQuery("SELECT s FROM SupplierEntity s WHERE (SELECT count(*) FROM ProductEntity p WHERE (p.productName LIKE '%" + productName + "%') AND (p.supplierId = s.supplierId)) > 0");
	}

}
