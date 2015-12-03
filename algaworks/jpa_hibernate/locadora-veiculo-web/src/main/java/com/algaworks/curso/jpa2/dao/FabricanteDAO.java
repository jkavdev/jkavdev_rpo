package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;

//classe fabricantedao que fara acesso ao banco de dados
//temos que implementar serializable para o jsf, guardar o estado do objeto

public class FabricanteDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//estamos fazendo a injecao desta instancia atraves do cdi
	@Inject
	private EntityManager manager;
	
	public void salvar(Fabricante fabricante){
		manager.persist(fabricante);
	}
	
	

}
