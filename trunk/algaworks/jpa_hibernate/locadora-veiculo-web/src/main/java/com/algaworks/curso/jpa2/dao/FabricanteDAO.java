package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;

public class FabricanteDAO implements Serializable {

	@Inject
	private EntityManager manager;

	public void salvar(Fabricante fabricante) {
		manager.persist(fabricante);
	}

	public void excluir(Fabricante fabricanteSelecionado)
			throws NegocioException {

	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		return manager.createQuery("from Fabricante").getResultList();
	}

}
