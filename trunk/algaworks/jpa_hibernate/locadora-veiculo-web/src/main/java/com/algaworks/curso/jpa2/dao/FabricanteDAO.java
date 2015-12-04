package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

//classe fabricantedao que fara acesso ao banco de dados
//temos que implementar serializable para o jsf, guardar o estado do objeto

public class FabricanteDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	// estamos fazendo a injecao desta instancia atraves do cdi
	@Inject
	private EntityManager manager;

	//o mesmo ocorre com a edicao do registro
	//sera chamado este metodo
	//como a entidade a ser editada ja foi gerenciado pelo manager, precisamos
	//fazer esta entidade ser gerenciada novamente
	//podemos fazer isto com o merge
	//pois ele verificara se ja existe um registro com o codigo informado
	//se existe ele apenas faz as alterações, se existirem
	public void salvar(Fabricante fabricante) {
		manager.merge(fabricante);
	}

	//para excluir-mos o objeto, precisamos que o manager o gerencie
	//pois depois do fim da requisao, o manager e fechado perdendo todas as informacoes anteriores
	//podemos fazer isso com o find, ele buscara no banco se existe o fabricante a ser excluido
	//como esse metodo fara uma alteração do banco temos que transformalo em um metodo transacional
	@Transactional
	public void excluir(Fabricante fabricanteSelecionado)throws NegocioException {
		fabricanteSelecionado = manager.find(Fabricante.class, fabricanteSelecionado.getCodigo());
		manager.remove(fabricanteSelecionado);
		manager.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		return manager.createQuery("from Fabricante").getResultList();
	}

	public Fabricante buscarPeloCodigo(Long codigo) {
		return manager.find(Fabricante.class, codigo);
	}

}
