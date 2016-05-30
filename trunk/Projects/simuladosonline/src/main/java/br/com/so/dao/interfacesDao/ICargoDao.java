package br.com.so.dao.interfacesDao;

import br.com.so.modelo.Cargo;
import br.com.so.modelo.Instituicao;

public interface ICargoDao extends GenericDao<Cargo, Long> {

	public boolean existe(Cargo cargo);

}
