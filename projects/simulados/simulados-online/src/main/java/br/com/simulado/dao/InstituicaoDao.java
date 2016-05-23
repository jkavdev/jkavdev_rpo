package br.com.simulado.dao;

import javax.persistence.EntityManager;

import br.com.simulado.modelo.Instituicao;

public class InstituicaoDao {

	EntityManager manager = JpaUtil.createEntityManager();

	public void salvar(Instituicao instituicao) {
		this.manager.getTransaction().begin();
		this.manager.persist(instituicao);
		this.manager.getTransaction().commit();
	}

}
