package br.com.jkavdev.northwind.database.interfaces;

import java.util.List;

import br.com.jkavdev.northwind.database.entities.SupplierEntity;
import br.com.jkavdev.northwind.database.utils.interfaces.IGenericDao;

public interface ISupplierDao extends IGenericDao<SupplierEntity, Long> {

	public List<SupplierEntity> findSuppliersByProductName(String productName);

}
