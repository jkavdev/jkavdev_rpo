package br.com.jkavdev.northwind.database.daos;

import javax.inject.Named;

import br.com.jkavdev.northwind.database.entities.ShipperEntity;
import br.com.jkavdev.northwind.database.interfaces.IShipperDao;
import br.com.jkavdev.northwind.database.utils.GenericDao;

@Named
public class ShipperDao extends GenericDao<ShipperEntity, Long> implements IShipperDao {

}
