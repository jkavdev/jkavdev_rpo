package br.com.simulados.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import br.com.simulados.dao.IProvaDao;
import br.com.simulados.modelo.Instituicao;
import br.com.simulados.modelo.Prova;

public class HibernateProvaDao extends HibernateGenericDao<Prova, Long> implements IProvaDao, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public List<Prova> provasPorInstituicao(Instituicao instituicao) {
		String sql = "select p from Prova p where p.instituicao = :instituicao";

		return this.manager.createQuery(sql, Prova.class).setParameter("instituicao", instituicao).getResultList();
	}

}
