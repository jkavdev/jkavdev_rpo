package br.com.simulados.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import br.com.simulados.dao.IInstituicaoDao;
import br.com.simulados.modelo.Instituicao;

public class HibernateInstituicaoDao extends HibernateGenericDao<Instituicao, Long> implements IInstituicaoDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean existe(Instituicao instituicao) {
		String sql = "select i from Instituicao i where i.nome = :nome ";
		
		@SuppressWarnings("unchecked")
		List<Instituicao> lista = this.manager.createQuery(sql)
				.setParameter("nome", instituicao.getNome().toUpperCase())
				.getResultList();
		
		if (lista.isEmpty()) {
			return false;
		}
		return true;
	}

}
