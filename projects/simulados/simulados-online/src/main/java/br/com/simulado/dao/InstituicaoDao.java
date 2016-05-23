package br.com.simulado.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.simulado.modelo.Instituicao;

public class InstituicaoDao implements Serializable {

	private static final long serialVersionUID = 1L;

	// EntityManager manager = JpaUtil.createEntityManager();
	@Inject
	private EntityManager manager;

	public void salvar(Instituicao instituicao) {
		this.manager.getTransaction().begin();
		this.manager.persist(instituicao);
		this.manager.getTransaction().commit();
	}

}
