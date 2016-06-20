package br.com.jkavdev.northwind.database.daos;

import javax.inject.Named;

import br.com.jkavdev.northwind.database.entities.EmployeeEntity;
import br.com.jkavdev.northwind.database.interfaces.IEmployeeDao;
import br.com.jkavdev.northwind.database.utils.GenericDao;

@Named
public class EmployeeDao extends GenericDao<EmployeeEntity, Long> implements IEmployeeDao {

}
