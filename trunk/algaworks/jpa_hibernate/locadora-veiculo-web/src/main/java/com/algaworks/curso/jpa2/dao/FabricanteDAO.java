package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class FabricanteDAO implements Serializable {

	@Inject
	private EntityManager manager;

	//como o metodo editar salva uma entidade ja gerenciada pelo entitymanager
	//teremos que fazer um merge das alterações realizadas neste objeto ja gerenciado
	//para isso usaremos o merge no lugar do persist
	public void salvar(Fabricante fabricante) {
		manager.merge(fabricante);
	}

	@Transactional
	public void excluir(Fabricante fabricante) throws NegocioException {
		// buscando o objeto pelo codigo do fabricante
		fabricante = manager.find(Fabricante.class, fabricante.getCodigo());
		manager.remove(fabricante);
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
