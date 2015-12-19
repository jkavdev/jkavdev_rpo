package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

//camada de negocio
//definicão do tipo de operaçoes a serem
//feitas

public class CadastroFabricanteService implements Serializable {

	private static final long serialVersionUID = 1L;

	// injetando o dao de fabricante
	@Inject
	private FabricanteDAO fabricanteDAO;

	// salvando o fabricante com a camada
	// de acesso ao banco
	// de acordo com algumas regras
	
	//informando que a metodo sera do tipo transacional
	//modificara o banco de dados
	@Transactional
	public void salvar(Fabricante fabricante) throws NegocioException {
		if (fabricante.getNome() == null || fabricante.getNome().trim().equals("")) {
			throw new NegocioException("O nome do Fabricante é obrigatório!");
		}
		this.fabricanteDAO.salvar(fabricante);
	}

}
