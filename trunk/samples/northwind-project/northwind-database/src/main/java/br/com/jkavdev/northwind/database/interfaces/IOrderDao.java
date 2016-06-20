package br.com.jkavdev.northwind.database.interfaces;

import br.com.jkavdev.northwind.database.entities.OrderEntity;
import br.com.jkavdev.northwind.database.utils.interfaces.IGenericDao;

public interface IOrderDao extends IGenericDao<OrderEntity, Long> {

}
