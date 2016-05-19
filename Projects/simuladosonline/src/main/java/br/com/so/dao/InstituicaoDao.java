package br.com.so.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.so.modelo.Instituicao;

public class InstituicaoDao {

	@Inject
	private EntityManager manager;

	public void adiciona(Instituicao instituicao) {
		System.out.println("Nome: " + instituicao.getNome());		
		this.manager.persist(instituicao);
	}

	public void remove(Instituicao instituicao) {
		this.manager.remove(instituicao);
	}

	public void atualiza(Instituicao instituicao) {
		manager.merge(instituicao);
	}

	public List<Instituicao> listaTodos() {
		CriteriaQuery<Instituicao> query = manager.getCriteriaBuilder()
				.createQuery(Instituicao.class);
		query.select(query.from(Instituicao.class));

		List<Instituicao> instituicoes = manager.createQuery(query)
				.getResultList();

		return instituicoes;
	}

	public Instituicao buscaPorId(Long id) {
		Instituicao instituicao = manager.find(Instituicao.class, id);
		return instituicao;
	}

}
