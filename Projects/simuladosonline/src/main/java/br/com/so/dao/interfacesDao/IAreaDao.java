package br.com.so.dao.interfacesDao;

import br.com.so.modelo.Area;

public interface IAreaDao extends GenericDao<Area, Long> {

	public boolean existe(Area area);

}
