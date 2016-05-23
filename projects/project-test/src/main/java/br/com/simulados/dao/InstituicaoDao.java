package br.com.simulados.dao;

import javax.persistence.EntityManager;

import br.com.simulados.modelo.Instituicao;
import br.com.simulados.util.JpaUtil;

public class InstituicaoDao {

	private EntityManager manager = JpaUtil.createEntityManager();

	public void salvar(Instituicao instituicao) {
		this.manager.getTransaction().begin();
		this.manager.persist(instituicao);
		this.manager.getTransaction().commit();
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
