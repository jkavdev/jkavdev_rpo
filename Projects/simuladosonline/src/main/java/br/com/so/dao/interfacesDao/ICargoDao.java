package br.com.so.dao.interfacesDao;

import br.com.so.modelo.Cargo;

public interface ICargoDao extends GenericDao<Cargo, Long> {

	public boolean existe(Cargo cargo);

}
