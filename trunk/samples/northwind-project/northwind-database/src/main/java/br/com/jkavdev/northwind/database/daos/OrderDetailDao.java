package br.com.jkavdev.northwind.database.daos;

import javax.inject.Named;

import br.com.jkavdev.northwind.database.entities.OrderDetailEntity;
import br.com.jkavdev.northwind.database.entities.keys.OrderDetailKeyEntity;
import br.com.jkavdev.northwind.database.interfaces.IOrderDetailDao;
import br.com.jkavdev.northwind.database.utils.GenericDao;

@Named
public class OrderDetailDao extends GenericDao<OrderDetailEntity, OrderDetailKeyEntity> implements IOrderDetailDao {

}
