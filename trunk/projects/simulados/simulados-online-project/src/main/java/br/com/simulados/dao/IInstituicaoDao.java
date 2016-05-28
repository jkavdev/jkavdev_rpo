package br.com.simulados.dao;

import br.com.simulados.modelo.Instituicao;

public interface IInstituicaoDao extends GenericDao<Instituicao, Long>{
	
	public boolean existe(Instituicao instituicao);

}
