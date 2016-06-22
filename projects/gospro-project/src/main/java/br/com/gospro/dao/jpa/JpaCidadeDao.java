package br.com.gospro.dao.jpa;

import java.io.Serializable;
import java.util.List;

import br.com.gospro.dao.ICidadeDao;
import br.com.gospro.model.Cidade;
import br.com.gospro.model.Estado;

public class JpaCidadeDao extends JpaGenericDao<Cidade, Long> implements ICidadeDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Cidade> buscarCidadePorEstado(Estado estado) {
		return getManager().createQuery("select c from Cidade c where c.estado = :estado", Cidade.class)
				.setParameter("estado", estado)
				.getResultList();
	}

}
