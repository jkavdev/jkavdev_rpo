package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;

public class FabricanteDAO implements Serializable {

	// fazendo que o objeto seja inserido automaticamente
	@Inject
	private EntityManager manager;

	public void salvar(Fabricante fabricante) {
		manager.persist(fabricante);
	}

	public void excluir(Fabricante fabricanteSelecionado) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		return manager.createQuery("from Fabricante").getResultList();
	}
	

}
