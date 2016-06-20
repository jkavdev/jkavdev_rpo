package br.com.jkavdev.northwind.database.daos;

import javax.inject.Named;

import br.com.jkavdev.northwind.database.entities.CustomerDemographicEntity;
import br.com.jkavdev.northwind.database.interfaces.ICustomerDemographicDao;
import br.com.jkavdev.northwind.database.utils.GenericDao;

@Named
public class CustomerDemographicDao extends GenericDao<CustomerDemographicEntity, Long> implements ICustomerDemographicDao {

}
