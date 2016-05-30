package br.com.so.dao.interfacesDao;

import br.com.so.modelo.Banca;
import br.com.so.modelo.Cargo;

public interface IBancaDao extends GenericDao<Banca, Long> {

	public boolean existe(Banca banca);
	
}
