package br.com.so.dao.interfacesDao;

import br.com.so.modelo.Banca;

public interface IBancaDao extends GenericDao<Banca, Long> {

	public boolean existe(Banca banca);
	
}
