package br.com.so.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.so.modelo.Instituicao;
import br.com.so.modelo.Prova;

public class ProvaDao {

	@Inject
	private EntityManager manager;

	public List<Prova> provasPorInstituicao(Instituicao instituicao) {
		String sql = "select p from Prova p where p.instituicao = :instituicao";
		
		return this.manager
				.createQuery(sql,Prova.class)
				.setParameter("instituicao", instituicao.getId())
				.getResultList();
	}

}
