package br.com.jkavdev.northwind.database.interfaces;

import br.com.jkavdev.northwind.database.entities.CustomerEntity;
import br.com.jkavdev.northwind.database.utils.interfaces.IGenericDao;

public interface ICustomerDao extends IGenericDao<CustomerEntity, Long> {

}
