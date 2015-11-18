package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CadastroFabricanteService implements Serializable {

	// injetando o fabricantedao
	@Inject
	private FabricanteDAO fabricanteDAO;

	// fazendo com que o metodo faça transação no banco
	@Transactional
	public void salvar(Fabricante fabricante) throws NegocioException {
		// se campo nulo ou campo com espacoes
		if (fabricante.getNome() == null
				|| fabricante.getNome().trim().equals("")) {
			throw new NegocioException("Nome do Fabricante é Obrigatório");
		}

		this.fabricanteDAO.salvar(fabricante);

	}

}
