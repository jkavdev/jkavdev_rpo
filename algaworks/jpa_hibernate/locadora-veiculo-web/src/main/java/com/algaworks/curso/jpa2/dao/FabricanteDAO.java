package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;

//camada de acesso ao banco de dados
//todo o acesso ao sera realizado por esta classe
public class FabricanteDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	// injetando o objeto atraves do cdi
	@Inject
	private EntityManager manager;

	// salvando o fabricante
	public void salvar(Fabricante fabricante) {
		manager.persist(fabricante);
	}

}
