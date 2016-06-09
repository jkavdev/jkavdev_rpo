package br.com.so.dao.interfacesDao;

import br.com.so.modelo.Disciplina;

public interface IDisciplinaDao extends GenericDao<Disciplina, Long> {

	public boolean existe(Disciplina disciplina);

}
