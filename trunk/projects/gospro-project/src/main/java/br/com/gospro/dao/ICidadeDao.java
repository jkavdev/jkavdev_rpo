package br.com.gospro.dao;

import java.util.List;

import br.com.gospro.model.Cidade;
import br.com.gospro.model.Estado;

public interface ICidadeDao extends GenericDao<Cidade, Long> {

	List<Cidade> buscarCidadePorEstado(Estado estado);

}
