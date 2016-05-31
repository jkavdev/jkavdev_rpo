package br.com.so.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import br.com.so.dao.interfacesDao.IProvaDao;
import br.com.so.modelo.Instituicao;
import br.com.so.modelo.Prova;

public class HibernateProvaDao extends HibernateGenericDao<Prova, Long> implements IProvaDao, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public List<Prova> provasPorInstituicao(Instituicao instituicao) {
		String sql = "select p from Prova p where p.instituicao = :instituicao";

		return this.getManager().createQuery(sql, Prova.class).setParameter("instituicao", instituicao).getResultList();
	}

}
