package br.com.so.dao.interfacesDao;

import br.com.so.modelo.Instituicao;

public interface IInstituicaoDao extends GenericDao<Instituicao, Long>{
	
	public boolean existe(Instituicao instituicao);

}
