package br.com.jkavdev.northwind.database.daos;

import javax.inject.Named;

import br.com.jkavdev.northwind.database.entities.CustomerEntity;
import br.com.jkavdev.northwind.database.interfaces.ICustomerDao;
import br.com.jkavdev.northwind.database.utils.GenericDao;

@Named
public class CustomerDao extends GenericDao<CustomerEntity, Long> implements ICustomerDao {

}
