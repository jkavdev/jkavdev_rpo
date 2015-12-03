package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

//classe onde ficara nossa logica de cadastro de fabricante

public class CadastroFabricanteService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//como a logica nao acessa o banco 
	//instanciamos um objeto dao que fara nosso processo
	//com o banco de dados
	@Inject
	private FabricanteDAO fabricanteDAO;
	
	//informando que esse metodo e do tipo de transacao
	//modificacao no banco de dados
	@Transactional
	public void salvar(Fabricante fabricante) throws NegocioException{
		
		//se o nome do fabricante for nulo ou contiver espacos e em branco
		if(fabricante.getNome() == null || fabricante.getNome().trim().equals("")){
			throw new NegocioException("O nome do Fabricante é obrigatório!");
		}
		
		this.fabricanteDAO.salvar(fabricante);
		
	}

}
