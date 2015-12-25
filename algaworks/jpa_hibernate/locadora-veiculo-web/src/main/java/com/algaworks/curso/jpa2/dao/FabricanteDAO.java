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
	
	//quando editamos um fabricante
	//chamamos a tela de cadastro
	//e quando isto ocorre o metodo cadastro e chamado
	//mas como o objeto ja foi gerenciado pelo manager
	//nao ocorrera a modificacao, temos que usar o 
	//merge, pois se ja existe ele modifica, 
	//se nao ele salva
	public void salvar(Fabricante fabricante) {
		manager.merge(fabricante);
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

	//buscando fabricante de acordo
	//com o codigo passado
	public Fabricante buscarPeloCodigo(Long codigo) {
		return manager.find(Fabricante.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarComPaginacao(int first, int pageSize) {
		return manager.createQuery("from Fabricante")
				.setFirstResult(first)
				.setMaxResults(pageSize)
				.getResultList();
	}

	public Long encontrarQuantidadeDeFabricantes() {
		return manager.createQuery("select count(f) from Fabricante f", Long.class).getSingleResult();
	}

}
