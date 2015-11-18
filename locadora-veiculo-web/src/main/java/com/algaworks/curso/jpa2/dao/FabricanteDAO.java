package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;

public class FabricanteDAO implements Serializable {
	
	//fazendo que o objeto seja inserido automaticamente
	@Inject
	private EntityManager manager;

	public void salvar(Fabricante fabricante) {
		manager.persist(fabricante);
	}

}
