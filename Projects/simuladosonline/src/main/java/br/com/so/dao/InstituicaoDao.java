package br.com.so.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.so.modelo.Instituicao;

public class InstituicaoDao {

	private EntityManager manager = JpaUtil.createEntityManager();

	public void salvar(Instituicao instituicao) {
		this.manager.getTransaction().begin();
		this.manager.persist(instituicao);
		this.manager.getTransaction().commit();
	}

	public boolean existe(Instituicao instituicao) {
		String sql = "select i from Instituicao i where i.nome = :nome ";
		List lista = this.manager.createQuery(sql).setParameter("nome", instituicao.getNome().toUpperCase())
				.getResultList();
		if (lista.isEmpty() || lista == null) {
			return true;
		}
		return false;
	}

}
