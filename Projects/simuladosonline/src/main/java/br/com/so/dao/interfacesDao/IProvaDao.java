package br.com.so.dao.interfacesDao;

import java.util.List;

import br.com.so.modelo.Instituicao;
import br.com.so.modelo.Prova;

public interface IProvaDao extends GenericDao<Prova, Long> {
	
	public List<Prova> provasPorInstituicao(Instituicao instituicao);

}
