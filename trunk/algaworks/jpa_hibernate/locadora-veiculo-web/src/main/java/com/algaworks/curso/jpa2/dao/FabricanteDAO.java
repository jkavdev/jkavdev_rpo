package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

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

	// listando todo os registros
	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		return manager.createQuery("from Fabricante").getResultList();
	}

	// como estamos tentando excluir um objeto que foi gerenciado pelo manager
	// temos que fazer que o manager conheca de novo este objeto
	// podemos usar o find

	// como e um metodo que faz alteracao no banco
	// precisamos abrir uma transacao
	@Transactional
	public void excluir(Fabricante fabricanteSelecionado) throws NegocioException {
		fabricanteSelecionado = manager.find(Fabricante.class, fabricanteSelecionado.getCodigo());
		manager.remove(fabricanteSelecionado);
		manager.flush();
	}

}
