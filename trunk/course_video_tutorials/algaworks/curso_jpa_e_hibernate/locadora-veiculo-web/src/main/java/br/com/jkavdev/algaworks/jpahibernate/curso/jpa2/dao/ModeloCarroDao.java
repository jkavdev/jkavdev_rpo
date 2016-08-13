package br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.model.ModeloCarro;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.service.NegocioException;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.util.jpa.Transactional;

public class ModeloCarroDao {

	@Inject
	private EntityManager manager;

	public void salvar(ModeloCarro modelo) {
		this.manager.merge(modelo);
	}

	public ModeloCarro buscarPeloCodigo(Long codigo) {
		return manager.find(ModeloCarro.class, codigo);
	}

	public List<ModeloCarro> buscarTodos() {
		return manager.createQuery("from ModeloCarro", ModeloCarro.class).getResultList();
	}

	@Transactional
	public void excluir(ModeloCarro modelo) throws NegocioException {
		modelo = buscarPeloCodigo(modelo.getCodigo());

		try {
			this.manager.remove(modelo);
			this.manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Este modelo não pode ser excluído");
		}
	}

}
