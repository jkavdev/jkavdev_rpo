package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class FabricanteDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	//para que possamos alterar um registro ja gerenciado pelo manager
	//usaremos o merge
	//no qual ira persistir o objeto e 
	//se o objeto ja existir no banco aplicara as mudancas feitas no objeto 
	public void salvar(Fabricante fabricante) {
		manager.merge(fabricante);
	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		return manager.createQuery("from Fabricante").getResultList();
	}

	// para remover-mos o objeto precisaremos gerenciar o objeto de volta para
	// manager
	// com a busca dos objetos no metodo buscartodos, uma vez que o entrega para
	// a pagina
	// o manager é encerrado
	// com teremos que fazer que o manager conheca este objeto ja uma vez
	// gerenciado
	@Transactional
	public void excluir(Fabricante fabricanteSelecionado)throws NegocioException {
		fabricanteSelecionado = manager.find(Fabricante.class,fabricanteSelecionado.getCodigo());
		manager.remove(fabricanteSelecionado);
		manager.flush();
	}

	public Fabricante buscarPeloFabricante(Long codigo) {
		return manager.find(Fabricante.class, codigo);
	}

}
