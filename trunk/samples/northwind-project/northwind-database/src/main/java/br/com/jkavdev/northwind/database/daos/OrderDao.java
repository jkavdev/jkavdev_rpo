package br.com.jkavdev.northwind.database.daos;

import javax.inject.Named;

import br.com.jkavdev.northwind.database.entities.OrderEntity;
import br.com.jkavdev.northwind.database.interfaces.IOrderDao;
import br.com.jkavdev.northwind.database.utils.GenericDao;

@Named
public class OrderDao extends GenericDao<OrderEntity, Long> implements IOrderDao {

}
