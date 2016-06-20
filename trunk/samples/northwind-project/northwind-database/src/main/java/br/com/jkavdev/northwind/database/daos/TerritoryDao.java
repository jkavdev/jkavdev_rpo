package br.com.jkavdev.northwind.database.daos;

import javax.inject.Named;

import br.com.jkavdev.northwind.database.entities.TerritoryEntity;
import br.com.jkavdev.northwind.database.interfaces.ITerritoryDao;
import br.com.jkavdev.northwind.database.utils.GenericDao;

@Named
public class TerritoryDao extends GenericDao<TerritoryEntity, String> implements ITerritoryDao {

}
