package br.com.jkavdev.northwind.database.interfaces;

import br.com.jkavdev.northwind.database.entities.CustomerCustomerDemoEntity;
import br.com.jkavdev.northwind.database.entities.keys.CustomerCustomerDemoKeyEntity;
import br.com.jkavdev.northwind.database.utils.interfaces.IGenericDao;

public interface ICustomerCustomerDemoDao extends IGenericDao<CustomerCustomerDemoEntity, CustomerCustomerDemoKeyEntity> {

}
