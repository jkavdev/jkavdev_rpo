package br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.model.Fabricante;

public class FabricanteDao implements Serializable {

	private static final long serialVersionUID = 1L;

	// informando que o manager será injetado
	@Inject
	private EntityManager manager;

	public void salvar(Fabricante fabricante) {
		manager.persist(fabricante);
	}

}
