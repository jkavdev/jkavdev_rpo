package br.com.jkavdev.northwind.database.interfaces;

import br.com.jkavdev.northwind.database.entities.EmployeeEntity;
import br.com.jkavdev.northwind.database.utils.interfaces.IGenericDao;

public interface IEmployeeDao extends IGenericDao<EmployeeEntity, Long> {

}
