package br.com.simulados.dao;

import java.util.List;

import br.com.simulados.modelo.Instituicao;
import br.com.simulados.modelo.Prova;

public interface IProvaDao extends GenericDao<Prova, Long> {
	
	public List<Prova> provasPorInstituicao(Instituicao instituicao);

}
