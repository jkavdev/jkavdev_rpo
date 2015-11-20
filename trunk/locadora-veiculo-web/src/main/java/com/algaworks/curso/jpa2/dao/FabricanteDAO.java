package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class FabricanteDAO implements Serializable {

	// fazendo que o objeto seja inserido automaticamente
	@Inject
	private EntityManager manager;

	public void salvar(Fabricante fabricante) {
		manager.persist(fabricante);
	}

	@Transactional
	public void excluir(Fabricante fabricanteSelecionado)
			throws NegocioException {
		fabricanteSelecionado = manager.find(Fabricante.class, fabricanteSelecionado.getCodigo());
		manager.remove(fabricanteSelecionado);
		manager.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		return manager.createQuery("from Fabricante").getResultList();
	}

}
