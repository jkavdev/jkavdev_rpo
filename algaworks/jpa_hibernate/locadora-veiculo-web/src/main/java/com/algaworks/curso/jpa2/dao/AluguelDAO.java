package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class AluguelDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	// como salvar a apolice nao fazr parte
	// da regra de negocio, podemos
	// salva no dao, onde temos acesso ao banco
	@Inject
	private ApoliceSeguroDAO apoliceSeguroDAO;

	@Transactional
	public void salvar(Aluguel aluguel) {
		apoliceSeguroDAO.salvar(aluguel.getApoliceSeguro());
		manager.merge(aluguel);
	}

}
