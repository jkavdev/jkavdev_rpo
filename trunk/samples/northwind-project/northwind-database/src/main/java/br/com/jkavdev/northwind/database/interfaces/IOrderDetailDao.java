package br.com.jkavdev.northwind.database.interfaces;

import br.com.jkavdev.northwind.database.entities.OrderDetailEntity;
import br.com.jkavdev.northwind.database.entities.keys.OrderDetailKeyEntity;
import br.com.jkavdev.northwind.database.utils.interfaces.IGenericDao;

public interface IOrderDetailDao extends IGenericDao<OrderDetailEntity, OrderDetailKeyEntity> {

}
