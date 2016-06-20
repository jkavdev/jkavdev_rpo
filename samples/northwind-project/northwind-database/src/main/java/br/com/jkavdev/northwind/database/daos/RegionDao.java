package br.com.jkavdev.northwind.database.daos;

import javax.inject.Named;

import br.com.jkavdev.northwind.database.entities.RegionEntity;
import br.com.jkavdev.northwind.database.interfaces.IRegionDao;
import br.com.jkavdev.northwind.database.utils.GenericDao;

@Named
public class RegionDao extends GenericDao<RegionEntity, Long> implements IRegionDao {

}
