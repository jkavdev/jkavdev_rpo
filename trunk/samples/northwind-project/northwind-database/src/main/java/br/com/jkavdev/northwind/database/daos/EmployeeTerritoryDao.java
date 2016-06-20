package br.com.jkavdev.northwind.database.daos;

import javax.inject.Named;

import br.com.jkavdev.northwind.database.entities.EmployeeTerritoryEntity;
import br.com.jkavdev.northwind.database.entities.keys.EmployeeTerritoryKeyEntity;
import br.com.jkavdev.northwind.database.interfaces.IEmployeeTerritoryDao;
import br.com.jkavdev.northwind.database.utils.GenericDao;

@Named
public class EmployeeTerritoryDao extends GenericDao<EmployeeTerritoryEntity, EmployeeTerritoryKeyEntity> implements IEmployeeTerritoryDao {

}
