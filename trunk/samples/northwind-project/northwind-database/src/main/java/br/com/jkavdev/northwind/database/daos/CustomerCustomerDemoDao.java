package br.com.jkavdev.northwind.database.daos;

import javax.inject.Named;

import br.com.jkavdev.northwind.database.entities.CustomerCustomerDemoEntity;
import br.com.jkavdev.northwind.database.entities.keys.CustomerCustomerDemoKeyEntity;
import br.com.jkavdev.northwind.database.interfaces.ICustomerCustomerDemoDao;
import br.com.jkavdev.northwind.database.utils.GenericDao;

@Named
public class CustomerCustomerDemoDao extends GenericDao<CustomerCustomerDemoEntity, CustomerCustomerDemoKeyEntity> implements ICustomerCustomerDemoDao {

}
